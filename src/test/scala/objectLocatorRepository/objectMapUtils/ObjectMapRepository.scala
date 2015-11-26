package objectLocatorRepository.objectMapUtils

import org.scalatest.selenium.WebBrowser


case class SelectorItem(keyId: String, selectorType: String)

object ObjectMap {
  val objectMap = Map(
    ("homepage.login", SelectorItem("li.main-nav.cd-signin a", "css")),
    ("homepage.signup", SelectorItem("li.main-nav.cd-signup a", "css")),

    ("signin.email", SelectorItem("signin-email", "id")),
    ("signin.password", SelectorItem("signin-password", "id")),

    ("signup.email", SelectorItem("signup-email", "id")),
    ("signup.username", SelectorItem("signup-username", "id")),
    ("signup.firstname", SelectorItem("signup-firstname", "id")),
    ("signup.lastname", SelectorItem("signup-lastname", "id")),
    ("signup.password", SelectorItem("signup-password", "id")),
    ("signup.acceptTerms", SelectorItem("accept-terms", "id")),

    ("new.button", SelectorItem("#new-button .new-button-icon", "css")),
    ("new.stample", SelectorItem("#new-button-icon .new-stample", "css"))
  )
}

// TODO I would like to remove dependency need to WebBrowser but don't know how yet, maybe with a trait that is using WebBrowser as a proxy
trait ObjectMapRepository extends WebBrowser {
  type Selector = this.Query

  private val objectMap = ObjectMap.objectMap

  def loadObjectMapFromFile = ??? // TODO implement a way to load map object resources from a file

  implicit def getLocator(keyId: String): Selector = {
      objectMap.get(keyId).map {
        case SelectorItem(selector, "id") => id(selector)
        case SelectorItem(selector, "css") => cssSelector(selector)
        case SelectorItem(selector, "xpath") => xpath(selector)
        case SelectorItem(selector, "class") => className(selector)
        case _ => throw new Error("Invalid selector type. Currently selectors allowed are: 'css' and 'id'")
      }.get
  }
}
/*
object pimpedWebBrowser {
  implicit class WebBrowserCustom(webBrowser: WebBrowser.type) {
    def getLocator(keyId: String): webBrowser.Query = {
      ObjectMap.objectMap.get(keyId).map {
        case SelectorItem(selector, "id") => webBrowser.id(selector)
        case SelectorItem(selector, "css") => webBrowser.cssSelector(selector)
        case _ => throw new Error("Invalid selector type. Currently selectors allowed are: 'css' and 'id'")
      }.get
    }
  }
}*/
