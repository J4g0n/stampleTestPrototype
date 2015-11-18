import org.openqa.selenium.WebDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.scalatest.selenium.WebBrowser
import org.scalatest.{FlatSpec, Matchers}


class Test extends FlatSpec with Matchers with WebBrowser {

  implicit val webDriver: WebDriver = new PhantomJSDriver
  go to "http://www.amazon.com"
  click on "twotabsearchtextbox"
  textField("twotabsearchtextbox").value = "Scala"
  submit()
  pageTitle should be ("Amazon.com: Scala")
  pageSource should include("Scala Cookbook: Recipes")
}
