package pageObjects.pageObjectUtils

import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser
import testConfig.TestConfig


abstract class BasePageObject (pageUrl: String) extends WebBrowser {
  implicit val webDriver: WebDriver = TestConfig.webDriver

  def openPage = go to pageUrl

  def isCurrentPage = pageUrl == currentUrl
}
