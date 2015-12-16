package testConfig

import java.io.File
import java.net.URL
import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.{RemoteWebDriver, CapabilityType, DesiredCapabilities}


case class TestConfig (
                        system: String = "osx",
                        browser: String = "firefox",
                        baseUrl: String = "localhost:9000",
                        pathToChromeOSX: String = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome",
                        pathToFirefoxOSX: String = "/Applications/FirefoxDeveloperEdition.app/Contents/MacOS/firefox-bin",
                        pathToChromeLinux: String = "/usr/bin/firefox",
                        pathToFirefoxLinux: String = "/usr/bin/google-chrome",
                        size: Option[(Int, Int)] = Some((1024, 728))
                      )
/*
case class FirefoxConfigLinux extends TestConfig("linux", "firefox", _, "/usr/bin/firefox", )
case class ChromeConfigLinux extends TestConfig()
case class FirefoxConfigOSX extends TestConfig()
case class ChromeConfigOSX extends TestConfig()
*/

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
    System.setProperty("webdriver.chrome.driver", testConfig.pathToChromeOSX)
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
    System.setProperty("webdriver.firefox.bin",testConfig.pathToFirefoxOSX)

    new FirefoxDriver(baseCaps)
  }

  private def createSeleniumGridDriver: WebDriver = {
    val baseCaps = new DesiredCapabilities

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
      case TestConfig(_, "chrome", _, _, _, _, _, _) => createChromeDriver
      case TestConfig(_, "firefox", _, _, _, _, _, _) => createFirefoxWebDriver
      // case TestConfig("phantomjs", _, _, _, _, _, _) => createPhantomJSDriver
      // case TestConfig("grid", _, _, _, _, _, _) => createSeleniumGridDriver // forget selenium grid for the moment
    }
    setMaxTimeoutBetweenActions(webDriver, 5)
    setFullscreen(webDriver)
  }
}
