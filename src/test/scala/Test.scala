import java.net.URL
import java.util.concurrent.TimeUnit

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.phantomjs.{PhantomJSDriver, PhantomJSDriverService}
import org.openqa.selenium.remote.{RemoteWebDriver, CapabilityType, DesiredCapabilities}
import org.scalatest.selenium.WebBrowser
import org.scalatest.{FlatSpec, Matchers}


class Test extends FlatSpec with Matchers with WebBrowser {

  val baseCaps = new DesiredCapabilities
  baseCaps.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true)

  // PhantomJS Capabilities
  //baseCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/local/bin/phantomjs")
  //baseCaps.setCapability("takesScreenshot", true)
  //baseCaps.setCapability("elementScrollBehavior", 1)
  //baseCaps.setBrowserName("phantomjs")

  System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome")

  implicit val webDriver: WebDriver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome())

  //webDriver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080))
  webDriver.manage().window().maximize()
  webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
  go to "http://staging.stample.co/login"
  println(webDriver.manage().window().getSize)

  "User" should "be able to login to Stample" in {
    click on cssSelector("li.main-nav.cd-signin a")
    click on id("signin-email")
    textField(id("signin-email")).value = "stampletest101@gmail.com"
    click on id("signin-password")
    pwdField(id("signin-password")).value = "whatever"
    submit()
  }

  "User" should "be able to log out Stample" in {
    click on cssSelector("#menu div.settings-menu")
    click on cssSelector("#menu div.settings-menu ul li:nth-child(5)")
  }

  "User" should "be able to sign up to Stample" in {
    val number = (Math.random() * 1000000).toInt.toString
    click on cssSelector("li.main-nav.cd-signup a")

    click on id("signup-email")
    emailField(id("signup-email")).value = s"quelquun$number@stample.co"
    click on id("signup-username")
    textField(id("signup-username")).value = s"JoDalton$number"
    click on id("signup-firstname")
    textField(id("signup-firstname")).value = "moins"
    click on id("signup-lastname")
    textField(id("signup-lastname")).value = "exunard"
    click on id("signup-password")
    pwdField(id("signup-password")).value = "whatever"
    click on id("accept-terms")
    submit()
  }

  "User" should "be able to do the onboarding" in {
    click on cssSelector("#onboarding-welcome .onboarding-button")
    click on cssSelector("#navigation .spaces-root-pane ul li:nth-child(1) .view-icon")
    click on cssSelector("#navigation .create-space")
    click on cssSelector("#category-creation #new-space-name")
    textField(cssSelector("#category-creation #new-space-name")).value = "Blabla"
    click on cssSelector("#category-creation .category-creation-button")
    click on cssSelector("#category-creation .category-creation-button")
  }

  "The amazon home page " should "have another this title" in {
    go to "http://www.amazon.com"
    click on "twotabsearchtextbox"
    textField("twotabsearchtextbox").value  = "Scala"
    submit()
    pageTitle should be("Amazon.com: Scala")
    pageSource should include("Scala Cookbook: Recipes")
  }
}
