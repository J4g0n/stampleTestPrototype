package objectLocatorRepository

import org.scalatest.selenium.WebBrowser


case class Selector(keyId: String, selectorType: String)


trait ObjectMapRepository {
  this: WebBrowser =>

  private val objectMap = Map(
    ("homepage.loginButton", Selector("li.main-nav.cd-signin a", "css")),
    ("homepage.signInText", Selector("signin-email", "id")),
    ("homepage.signInPassword", Selector("signin-password", "id"))
  )

  def loadObjectMapFromFile = ???

  implicit def getLocator(keyId: String): this.Query = {
    objectMap.get(keyId).map {
      case Selector(selector, "id") => id(selector)
      case Selector(selector, "css") => cssSelector(selector)
      case _ => throw new Error("Invalid selector type. Currently selectors allowed are: 'css' and 'id'")
    }.get
  }
}
