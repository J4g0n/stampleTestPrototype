package pageObjects.pageObjectUtils

import objectLocatorRepository.objectMapUtils._
import org.openqa.selenium.WebDriver
import testUtils.WebBrowserCustom
import testConfig.TestConfig


abstract class BasePage (val pageUrl: String = TestConfig.baseUrl) extends WebBrowserCustom {
  implicit val webDriver: WebDriver = TestConfig.webDriver

  def isCurrentUrlEqualsTo(url: String): Boolean = currentUrl == url

  def closePage = close

  def quitBrowser = quit

  implicit def getLocator(selector: Selector): this.Query = {
    val selectedElement = selector match {
      case IdSelector(selectorId) => id(selectorId)
      case CssSelector(selectorCss) => cssSelector(selectorCss)
      case XPathSelector(selectorXPath) => xpath(selectorXPath)
      case ClassSelector(selectorClass) => className(selectorClass)
      case _ => throw new Error("Invalid selector type. Currently selectors allowed are: 'css' and 'id'")
    }
    //new WebDriverWait(webDriver, 30).until(ExpectedConditions.visibilityOfElementLocated(selectedElement.by))

    selectedElement
  }
}
