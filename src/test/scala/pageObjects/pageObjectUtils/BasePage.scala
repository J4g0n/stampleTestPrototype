package pageObjects.pageObjectUtils

import objectLocatorRepository.objectMapUtils.Selector
import org.openqa.selenium.WebDriver
import testUtils.WebBrowserCustom
import testConfig.TestConfig


abstract class BasePage (pageUrl: String = TestConfig.baseUrl) extends WebBrowserCustom {
  implicit val webDriver: WebDriver = TestConfig.webDriver

  def isCurrentUrlEqualsTo(url: String): Boolean = currentUrl == url

  def openPage = {
    deleteAllCookies
    go to pageUrl
  }

  def closePage = close

  def quitBrowser = quit

  implicit def getLocator(selector: Selector): this.Query = {
    val selectedElement = selector match {
      case Selector(selectorId, "id") => id(selectorId)
      case Selector(selectorCss, "css") => cssSelector(selectorCss)
      case Selector(selectorXPath, "xpath") => xpath(selectorXPath)
      case Selector(selectorClass, "class") => className(selectorClass)
      case _ => throw new Error("Invalid selector type. Currently selectors allowed are: 'css' and 'id'")
    }

    //new WebDriverWait(webDriver, 30).until(ExpectedConditions.visibilityOfElementLocated(selectedElement.by))
    /*find(selectedElement).get match {
      case v: TextField => v.clear
      case v: PasswordField => v.clear
      case x: ValueElement => x.clear
      case x => println(x)
    }*/
    selectedElement
  }
}
