package objectLocatorRepository

import org.scalatest.selenium.WebBrowser


case class Selector(keyId: String, selectorType: String)
/*object Selector {
  def apply(keyId: String, selectorType: String) = new Selector(keyId, selectorType)
}*/


object ObjectMapRepository {
  val objectMap = Map(
    ("stample.homepage.loginButton", Selector("li.main-nav.cd-signin a", "css")),
    ("stample.homepage.signInText", Selector("signin-email", "id")),
    ("stample.homepage.signInPassword", Selector("signin-password", "id"))
  )

  def getLocator(keyId: String)(webBrowser: WebBrowser) = {
    objectMap.get(keyId).map {
      case Selector(selector, "id") => webBrowser.id(selector)
      case Selector(selector, "css") => webBrowser.cssSelector(selector)
      case _ => throw new Error("Invalid selector type. Currently selectors allowed are: 'css' and 'id'")
    }.get
  }
}
