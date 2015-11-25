package pageObjects

import pageObjects.pageObjectUtils.BasePageObject
import testConfig.TestConfig


class StampleHomePage extends BasePageObject(TestConfig.baseUrl) {
  val LOGIN_BUTTON = cssSelector("li.main-nav.cd-signin a")
  val EMAIL_SIGNIN_TEXTFIELD = id("signin-email")
  val PASSWORD_SIGNIN_TEXTFIELD = id("signin-password")

  def isCurrentUrlEqualsTo(url: String): Boolean = currentUrl == url

  def signInWith(username: String, password: String): StampleApp = {
    click on LOGIN_BUTTON
    click on EMAIL_SIGNIN_TEXTFIELD
    textField(EMAIL_SIGNIN_TEXTFIELD).value = username
    click on PASSWORD_SIGNIN_TEXTFIELD
    pwdField(PASSWORD_SIGNIN_TEXTFIELD).value = password
    submit()

    new StampleApp
  }
}

