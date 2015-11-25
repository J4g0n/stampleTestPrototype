package pageObjects

import objectLocatorRepository.ObjectMapRepository
import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser
import pageObjects.pageObjectUtils.BasePage
import testConfig.TestConfig


class HomePage(implicit webDriver: WebDriver) extends BasePage(TestConfig.baseUrl) {

  val LOGIN_BUTTON = "stample.homepage.loginButton"
  val EMAIL_SIGNIN_TEXTFIELD = "stample.homepage.signInText"
  val PASSWORD_SIGNIN_TEXTFIELD = "stample.homepage.signInPassword"

  def isCurrentUrlEqualsTo(url: String): Boolean = currentUrl == url

  def queryObjectMap(str: String) = ObjectMapRepository.getLocator(str)(HomePage.this)

  def signInWith(username: String, password: String): AppMainPage = {
    click on queryObjectMap(LOGIN_BUTTON)
    click on queryObjectMap(EMAIL_SIGNIN_TEXTFIELD)
    textField(queryObjectMap(EMAIL_SIGNIN_TEXTFIELD)).value = username
    click on queryObjectMap(PASSWORD_SIGNIN_TEXTFIELD)
    pwdField(queryObjectMap(PASSWORD_SIGNIN_TEXTFIELD)).value = password
    submit()

    new AppMainPage
  }
}

