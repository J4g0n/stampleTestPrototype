package testConfig

import java.io.File
import java.net.URL
import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.{RemoteWebDriver, CapabilityType, DesiredCapabilities}

import com.github.kxbmap.configs.syntax._
import com.typesafe.config.ConfigFactory


case class TestConfig (
                        browser: String,
                        baseUrl: String,
                        browserPath: String,
                        dimension: Option[(Int, Int)]
                      )


/**
  * Created by dev on 20/11/15.
  */
object TestConfig {
  val testConfig: TestConfig = loadConfig()
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
    System.setProperty("webdriver.chrome.driver", testConfig.browserPath)
    val chromeCapabilities = DesiredCapabilities.chrome

    new RemoteWebDriver(new URL("http://localhost:9515"), chromeCapabilities)
  }

  private def createPhantomJSDriver: WebDriver = {
    val baseCaps = DesiredCapabilities.phantomjs
    baseCaps.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true)
    baseCaps.setJavascriptEnabled(true)
    baseCaps.setCapability("takesScreenshot", true)

    new RemoteWebDriver(new URL("http://localhost:4444"), baseCaps)
  }

  private def createFirefoxWebDriver: WebDriver = {
    val baseCaps = DesiredCapabilities.firefox
    System.setProperty("webdriver.firefox.bin",testConfig.browserPath)

    new FirefoxDriver(baseCaps)
  }

  private def createSeleniumGridDriver: WebDriver = {
    val baseCaps = new DesiredCapabilities

    new RemoteWebDriver(new URL("http://jenkins.localhost:4444/wd/hub"), baseCaps)
  }

  private def setFullscreen(webDriver: WebDriver): WebDriver = {
    testConfig.dimension match {
      case Some(dimensions) => webDriver.manage().window().setSize(new org.openqa.selenium.Dimension(dimensions._1, dimensions._2))
      case _ => webDriver.manage().window().maximize()
    }
    webDriver
  }

  private def setMaxTimeoutBetweenActions(webDriver: WebDriver, seconds: Int): WebDriver = {
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    webDriver
  }

  private def loadConfig(maybeConfigName: Option[String] = None): TestConfig = {
    val configName = maybeConfigName.getOrElse("defaultSettings")
    val config = ConfigFactory.load()
    config.get[TestConfig](configName)
  }

  private def createWebDriver: WebDriver = {
    val webDriver: WebDriver = testConfig match {
      case TestConfig("chrome", _, _) => createChromeDriver
      case TestConfig("firefox", _, _) => createFirefoxWebDriver
    }
    setMaxTimeoutBetweenActions(webDriver, 5)
    setFullscreen(webDriver)
  }
}
