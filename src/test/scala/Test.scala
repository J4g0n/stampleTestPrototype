import java.net.URL

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
  go to "http://staging.stample.co/login"
  println(webDriver.manage().window().getSize)

  "User" should "be able to sign up to Stample" in {
    println("\n" + currentUrl + "\n")
    // webDriver.findElement(By.cssSelector("li.cd-signin a")).click
    // captureTo("./picture")
    click on cssSelector("li.cd-signin a")
    Thread.sleep(1000)
    println("user modal form is displayed: " + webDriver.findElement(By.cssSelector("div.cd-user-modal")).isDisplayed)

    click on id("signin-email")
    textField(id("signin-email")).value = "simon.andreux@gmail.com"
    println("user password field is displayed: " + webDriver.findElement(By.id("signin-password")).isDisplayed)
    click on id("signin-password")
    pwdField(id("signin-password")).value = "e^(i*Pi)+1=0"
    submit()
    /*click on cssSelector("input#signup-username")
    textField(cssSelector("input#signup-username")).value = "jagon"
    click on cssSelector("input#signup-firstname")
    textField(cssSelector("input#signup-firstname")).value = "simon"
    click on cssSelector("input#signup-lastname")
    textField(cssSelector("input#signup-lastname")).value = "andreux"
    click on cssSelector("input#signup-password")
    textField(cssSelector("input#signup-password")).value = "batterie"
    click on checkbox(cssSelector("input#accept-terms"))
    click on checkbox(cssSelector("input#signupFormSubmit"))*/

    println("\n" + currentUrl + "\n")
    /*click on "signin-password"
    textField("signin-password").value  = "e^(i*Pi)+1=0"
    submit()*/
    //pageTitle should be("Amazon.com: Scala")
    //pageSource should include("Scala Cookbook: Recipes")
  }

  /*"The amazon home page " should "have another this title" in {
    go to "http://www.amazon.com"
    click on "twotabsearchtextbox"
    textField("twotabsearchtextbox").value  = "Scala"
    submit()
    pageTitle should be("Amazon.com: Scala")
    pageSource should include("Scala Cookbook: Recipes")
  }*/
}
