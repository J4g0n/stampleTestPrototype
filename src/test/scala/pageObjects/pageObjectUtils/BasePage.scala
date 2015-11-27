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
    selector match {
      case Selector(selector, "id") => id(selector)
      case Selector(selector, "css") => cssSelector(selector)
      case Selector(selector, "xpath") => xpath(selector)
      case Selector(selector, "class") => className(selector)
      case _ => throw new Error("Invalid selector type. Currently selectors allowed are: 'css' and 'id'")
    }
  }
}
