package pageObjects.pageObjectUtils

import objectLocatorRepository.ObjectMapRepository
import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser
import testConfig.TestConfig


abstract class BasePage (pageUrl: String) extends WebBrowser with ObjectMapRepository {
  implicit val webDriver: WebDriver = TestConfig.webDriver
  implicit def locator(id: String): this.Query = getLocator(id)

  def openPage = go to pageUrl

  def closePage = close

  def quitBrowser = quit
}
