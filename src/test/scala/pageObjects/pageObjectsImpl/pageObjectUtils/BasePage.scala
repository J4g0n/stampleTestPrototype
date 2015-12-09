package pageObjects.pageObjectsImpl.pageObjectUtils

import pageObjects.Page
import testConfig.TestConfig


abstract class BasePage (val pageUrl: String = TestConfig.baseUrl) extends Page with WebBrowserCustom {
  def openPage: this.type = {
    deleteAllCookies
    go to pageUrl
    scrollToTop
    this
  }

  def isCurrentUrlEqualsTo(url: String): Boolean = currentUrl == url

  def closePage = close

  def quitBrowser = quit
}
