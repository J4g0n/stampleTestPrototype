package pageObjects.pageObjectUtils

import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser
import testConfig.TestConfig


abstract class BasePage (pageUrl: String) extends WebBrowser {
  implicit val webDriver: WebDriver = TestConfig.webDriver

  def openPage = go to pageUrl

  def closePage = close

  def quitBrowser = quit
}
