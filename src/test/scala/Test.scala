import org.openqa.selenium.WebDriver
import org.openqa.selenium.phantomjs.{PhantomJSDriverService, PhantomJSDriver}
import org.openqa.selenium.remote.{CapabilityType, DesiredCapabilities}
import org.scalatest.selenium.WebBrowser
import org.scalatest.{FlatSpec, Matchers}


class Test extends FlatSpec with Matchers with WebBrowser {

  val baseCaps = new DesiredCapabilities
  baseCaps.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true)
  baseCaps.setCapability("takesScreenshot", true)
  baseCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/local/bin/phantomjs")

  implicit val webDriver: WebDriver = new PhantomJSDriver(baseCaps)
  go to "http://www.amazon.com"
  click on "twotabsearchtextbox"
  textField("twotabsearchtextbox").value = "Scala"
  submit()
  pageTitle should be ("Amazon.com: Scala")
  pageSource should include("Scala Cookbook: Recipes")
}
