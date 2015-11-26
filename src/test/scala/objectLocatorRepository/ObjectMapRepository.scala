package objectLocatorRepository

import org.scalatest.selenium.WebBrowser


case class Selector(keyId: String, selectorType: String)


trait ObjectMapRepository {
  this: WebBrowser =>

  val objectMap = Map(
    ("stample.homepage.loginButton", Selector("li.main-nav.cd-signin a", "css")),
    ("stample.homepage.signInText", Selector("signin-email", "id")),
    ("stample.homepage.signInPassword", Selector("signin-password", "id"))
  )

  def getLocator(keyId: String) = {
    objectMap.get(keyId).map {
      case Selector(selector, "id") => id(selector)
      case Selector(selector, "css") => cssSelector(selector)
      case _ => throw new Error("Invalid selector type. Currently selectors allowed are: 'css' and 'id'")
    }.get
  }
}
