package testConfig

import java.io.File
import java.net.URL
import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.{RemoteWebDriver, CapabilityType, DesiredCapabilities}


case class TestConfig (
                        browser: String = "firefox",
                        baseUrl: String = "http://staging.stample.co/",
                        size: Option[(Int, Int)] = None
                      )


/**
  * Created by dev on 20/11/15.
  */
object TestConfig {
  val testConfig: TestConfig = new TestConfig
  val webDriver: WebDriver = createWebDriver

  def baseUrl = testConfig.baseUrl

  private def getDefaultCapabilities: DesiredCapabilities = {
    val baseCaps = new DesiredCapabilities
    baseCaps.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true)
    baseCaps
  }

  private def addClipperExtension(caps: DesiredCapabilities) = {
    val chromeOptions = new ChromeOptions
    val extensionFile = new File("./lklfljajeedlijndcpjiggknddhiljkm.crx")
    chromeOptions.addExtensions(extensionFile)
    caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions)
    caps
  }

  private def createChromeDriver: WebDriver = {
    System.setProperty("webdriver.chrome.driver", "/usr/bin/google-chrome")
    val chromeCapabilities = DesiredCapabilities.chrome
    // TODO useless atm because we can't click to trigger clipper see: http://stackoverflow.com/questions/25557533/open-a-chrome-extension-through-selenium-webdriver
    // TODO there is still a hope to load it manually but i have not tried it yet
    // val capsWithClipperExtension = addClipperExtension(chromeCapabilities)

    new RemoteWebDriver(new URL("http://localhost:9515"), chromeCapabilities)
  }

  private def createPhantomJSDriver: WebDriver = {
    val baseCaps = DesiredCapabilities.phantomjs
    baseCaps.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true)
    baseCaps.setJavascriptEnabled(true)
    baseCaps.setCapability("takesScreenshot", true)

    //baseCaps.setCapability("elementScrollBehavior", 1)
    //baseCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/local/bin/phantomjs")

    new RemoteWebDriver(new URL("http://localhost:4444"), baseCaps)
  }

  private def createFirefoxWebDriver: WebDriver = {
    val baseCaps = DesiredCapabilities.firefox
    System.setProperty("webdriver.firefox.bin","/usr/bin/firefox")
    //System.setProperty("webdriver.firefox.bin","/Applications/FirefoxDeveloperEdition.app/Contents/MacOS/firefox-bin")
    //val profile = new ProfilesIni
    //val firefoxProfile = profile.getProfile("Library/Application Support/Firefox/Profiles/0xd5cpw0.dev-edition-default/")
    //baseCaps.setCapability("marionette", true)

    new FirefoxDriver(baseCaps)
  }

  // Run tests against selenium grid https://wiki.jenkins-ci.org/display/JENKINS/Selenium+Plugin
  private def createSeleniumGridDriver: WebDriver = {
    //System.setProperty("webdriver.firefox.bin","/Applications/FirefoxDeveloperEdition.app/Contents/MacOS/firefox-bin")
    //System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome")

    val baseCaps = new DesiredCapabilities
    //baseCaps.setVersion("9.0.1")
    //baseCaps.setPlatform(org.openqa.selenium.Platform.WINDOWS)

    new RemoteWebDriver(new URL("http://jenkins.localhost:4444/wd/hub"), baseCaps)
  }

  private def setFullscreen(webDriver: WebDriver): WebDriver = {
    testConfig.size match {
      case Some(dimensions) => webDriver.manage().window().setSize(new org.openqa.selenium.Dimension(dimensions._1, dimensions._2))
      case _ => webDriver.manage().window().maximize()
    }
    webDriver
  }

  private def setMaxTimeoutBetweenActions(webDriver: WebDriver, seconds: Int): WebDriver = {
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    webDriver
  }

  private def createWebDriver: WebDriver = {
    val webDriver: WebDriver = testConfig match {
      case TestConfig("chrome", _, _) => createChromeDriver
      case TestConfig("phantomjs", _, _) => createPhantomJSDriver
      case TestConfig("firefox", _, _) => createFirefoxWebDriver
      case TestConfig("grid", _, _) => createSeleniumGridDriver // forget selenium grid for the moment
    }
    setMaxTimeoutBetweenActions(webDriver, 10)
    setFullscreen(webDriver)
  }
}
