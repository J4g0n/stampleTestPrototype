package pageObjects

import org.openqa.selenium.WebDriver
import pageObjects.pageObjectUtils.BasePage
import testConfig.TestConfig


class HomePage(implicit webDriver: WebDriver) extends BasePage(TestConfig.baseUrl) {

  val LOGIN_BUTTON  = "stample.homepage.loginButton"
  val EMAIL_SIGNIN_TEXTFIELD = "stample.homepage.signInText"
  val PASSWORD_SIGNIN_TEXTFIELD = "stample.homepage.signInPassword"

  def isCurrentUrlEqualsTo(url: String): Boolean = currentUrl == url

  def signInWith(username: String, password: String): AppMainPage = {
    click on LOGIN_BUTTON
    click on EMAIL_SIGNIN_TEXTFIELD
    textField(EMAIL_SIGNIN_TEXTFIELD).value = username
    click on PASSWORD_SIGNIN_TEXTFIELD
    pwdField(PASSWORD_SIGNIN_TEXTFIELD).value = password
    submit()

    new AppMainPage
  }
}

