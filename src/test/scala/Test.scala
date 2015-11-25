import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser
import org.scalatest.{GivenWhenThen, FlatSpec, Matchers}
import testConfig.TestConfig


class Test extends FlatSpec with GivenWhenThen with Matchers with WebBrowser {
  implicit val webDriver: WebDriver = TestConfig.webDriver

  go to "http://staging.stample.co/login"

  "User" should "be able to login to Stample" in {
    click on cssSelector("li.main-nav.cd-signin a")
    click on id("signin-email")
    textField(id("signin-email")).value = "stampletest101@gmail.com"
    click on id("signin-password")
    pwdField(id("signin-password")).value = "whatever"
    submit()
  }

  "User" should "be able to log out of Stample" in {
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

  "The amazon home page " should "have another title when searching" in {
    go to "http://www.amazon.com"
    click on "twotabsearchtextbox"
    textField("twotabsearchtextbox").value  = "Scala"
    submit()
    pageTitle should be("Amazon.com: Scala")
    pageSource should include("Scala Cookbook: Recipes")
  }
}
