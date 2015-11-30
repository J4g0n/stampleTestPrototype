package testConfig

import java.net.URL
import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebDriver
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

  private def createChromeDriver: WebDriver = {
    System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome")

    new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome)
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
    System.setProperty("webdriver.firefox.bin","/Applications/FirefoxDeveloperEdition.app/Contents/MacOS/firefox-bin")
    //val profile = new ProfilesIni
    //val firefoxProfile = profile.getProfile("Library/Application Support/Firefox/Profiles/0xd5cpw0.dev-edition-default/")
    //baseCaps.setCapability("marionette", true)

    new FirefoxDriver(baseCaps)
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
    }
    setMaxTimeoutBetweenActions(webDriver, 10)
    setFullscreen(webDriver)
  }
}
