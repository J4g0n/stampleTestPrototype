package config

import java.io.File
import java.net.URL
import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.{RemoteWebDriver, CapabilityType, DesiredCapabilities}



object Browser extends Enumeration {
  val FIREFOX = Value("FIREFOX")
  val CHROME = Value("CHROME")
}

object BaseUrl extends Enumeration {
  val LOCALHOST = Value("localhost:9000")
  val STAGING = Value("http://staging.stample.co")
  val DEV = Value("https://dev.stample.co")
  val PROD = Value("https://stample.co")
}

case class SeleniumConfig(
                           baseUrl: BaseUrl.Value = {
                             val hostname: Option[String] = Option(System.getenv("HOSTNAME"))
                             hostname match {
                               case Some("dev") => BaseUrl.DEV
                               case Some("staging") => BaseUrl.STAGING
                               case Some("prod") => BaseUrl.PROD
                               case _ => BaseUrl.LOCALHOST
                             }
                           },
                           browser: Browser.Value = {
                             val browser: Option[String] = Option(System.getenv("TEST_BROWSER"))
                             browser match {
                               case Some("firefox") => Browser.FIREFOX
                               case Some("chrome") => Browser.CHROME
                               // default browser is chrome because it can run on both local machine and server
                               // (+ it seems like everyone in the team is using chrome to develop)
                               case _ => Browser.CHROME
                             }
                           },
                           resourcesPath: String,
                           pathToChrome: String,
                           pathToFirefox: String,
                           size: Option[(Int, Int)] = Some(1200, 780)
                         )

object SeleniumConfig {
  def buildConfig = {
    val osType: String = System.getProperty("os.name")
    println("OS = " + osType)
    osType match {
      case "Mac OS X" => osxConfig
      case "Linux" => linuxConfig
      case notSupportedOs /* like windaube ahah */ => throw new Error(s"Not supported OS, available os are OSX and LINUX: $notSupportedOs")
    }
  }

  private val linuxConfig: SeleniumConfig = SeleniumConfig(
    resourcesPath = "/home/stample/",
    pathToChrome = "/usr/bin/google-chrome",
    pathToFirefox = "/usr/bin/firefox"
  )

  private val osxConfig: SeleniumConfig = SeleniumConfig(
    resourcesPath = "~/",
    pathToChrome = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome",
    pathToFirefox = "/Applications/FirefoxDeveloperEdition.app/Contents/MacOS/firefox-bin"
  )
}


object TestConfig {
  val testConfig = SeleniumConfig.buildConfig

  val webDriver: WebDriver = createWebDriver

  val baseUrl = testConfig.baseUrl.toString

  val resourcesPath = testConfig.resourcesPath

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
    System.setProperty("webdriver.chrome.driver", testConfig.pathToChrome)
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
    System.setProperty("webdriver.firefox.bin",testConfig.pathToFirefox)

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
    // Declare all timeouts
    webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
    webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS)
    webDriver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS)
    webDriver
  }

  private def createWebDriver: WebDriver = {
    val webDriver: WebDriver = testConfig.browser match {
      case Browser.CHROME => createChromeDriver
      case Browser.FIREFOX => createFirefoxWebDriver
    }
    setMaxTimeoutBetweenActions(webDriver, 5)
    setFullscreen(webDriver)
  }
}
