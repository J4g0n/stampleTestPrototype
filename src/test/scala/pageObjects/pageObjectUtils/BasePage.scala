package pageObjects.pageObjectUtils

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
}
