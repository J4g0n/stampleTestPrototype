package pageObjects

import objectLocatorRepository.HomePageElements
import pageObjects.pageObjectUtils.BasePage
import testConfig.TestConfig


class HomePage extends BasePage(TestConfig.baseUrl) with HomePageElements {
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

