package testConfig

import java.net.URL
import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebDriver
import org.openqa.selenium.phantomjs.{PhantomJSDriver, PhantomJSDriverService}
import org.openqa.selenium.remote.{RemoteWebDriver, CapabilityType, DesiredCapabilities}


case class TestConfig (
                        browser: String = "chrome",
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

    // /!\ Requires chromeDriver to be started on port 9515
    new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome())
  }

  private def createPhantomJSDriver: WebDriver = {
    val baseCaps = getDefaultCapabilities

    baseCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/local/bin/phantomjs")
    baseCaps.setCapability("takesScreenshot", true)
    baseCaps.setCapability("elementScrollBehavior", 1)
    baseCaps.setBrowserName("phantomjs")

    // TODO we should investigate RemoteWebDriver to use phantomJS too
    new PhantomJSDriver(baseCaps)
  }

  private def setFullscreen(webDriver: WebDriver): WebDriver = {
    //webDriver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080))
    webDriver.manage().window().maximize()
    webDriver
  }

  // This represents the waiting time before an element is loaded inside a web page before we can perform action
  private def setMaxTimeoutBetweenActions(webDriver: WebDriver, seconds: Int): WebDriver = {
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    webDriver
  }

  private def createWebDriver: WebDriver = {
    val webDriver: WebDriver = testConfig match {
      case TestConfig("chrome", _, _) => createChromeDriver
      case _ => createPhantomJSDriver
    }
    setFullscreen(webDriver)
    setMaxTimeoutBetweenActions(webDriver, 10)
  }
}
