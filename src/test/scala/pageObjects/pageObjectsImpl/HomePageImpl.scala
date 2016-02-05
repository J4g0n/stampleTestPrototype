package pageObjects.pageObjectsImpl

import objectLocatorRepository.{HomepageSelectors, SignupPageSelectors, LoginPageSelectors}
import pageObjects.HomePage
import pageObjects.pageObjectsImpl.pageObjectUtils.BasePage
import testConfig.TestConfig


trait HomePageImpl {
  self: AppMainPageImpl =>

  val homePage: HomePage = new DefaultHomePageImpl

  class DefaultHomePageImpl extends BasePage(TestConfig.baseUrl) with HomePage with HomepageSelectors with LoginPageSelectors with SignupPageSelectors {
    def signInWith(username: String, password: String) = {
      click on HOMEPAGE_LOGIN_BUTTON
      click on SIGNIN_EMAIL_TEXTFIELD
      textField(SIGNIN_EMAIL_TEXTFIELD).value = username
      click on SIGNIN_PASSWORD_TEXTFIELD
      pwdField(SIGNIN_PASSWORD_TEXTFIELD).value = password
      submit()
    }

    def signUpWith(email: String, username: String, firstname: String, lastname: String, password: String) = {
      click on HOMEPAGE_SIGNUP_BUTTON

      click on SIGNUP_ACCEPT_TERMS_BUTTON
      click on SIGNUP_EMAIL_TEXTFIELD
      emailField(SIGNUP_EMAIL_TEXTFIELD).value = email
      click on SIGNUP_USERNAME_TEXTFIELD
      textField(SIGNUP_USERNAME_TEXTFIELD).value = username
      click on SIGNUP_FIRSTNAME_TEXTFIELD
      textField(SIGNUP_FIRSTNAME_TEXTFIELD).value = firstname
      click on SIGNUP_LASTNAME_TEXTFIELD
      textField(SIGNUP_LASTNAME_TEXTFIELD).value = lastname
      click on SIGNUP_PASSWORD_TEXTFIELD
      pwdField(SIGNUP_PASSWORD_TEXTFIELD).value = password
      submit()
    }
  }
}





trait Node {
  val selector: String
}

case class Leaf(selector: String) extends Node



object EntryPoint extends Node {
  val selector = "#layout"
  val topMenu = TopMenu
}


object TopMenu extends Node {
  val selector = ".topMenu"
  val searchInput: Leaf = Leaf(".search-input")
}

object Test {
  EntryPoint.topMenu.searchInput
}