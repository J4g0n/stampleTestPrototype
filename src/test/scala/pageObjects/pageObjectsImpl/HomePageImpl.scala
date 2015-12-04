package pageObjects.pageObjectsImpl

import objectLocatorRepository.{SignupPageSelectors, LoginPageSelectors, HomePageSelectors}
import pageObjects.HomePage


trait HomePageImpl {
  self: AppMainPageImpl =>

  val homePage: HomePage = new DefaultHomePageImpl

  class DefaultHomePageImpl extends HomePage with HomePageSelectors with LoginPageSelectors with SignupPageSelectors {
    def openPage: HomePage = {
      deleteAllCookies
      go to pageUrl
      this
    }

    def signInWith(username: String, password: String) = {
      click on HOMEPAGE_LOGIN_BUTTON
      click on SIGNIN_EMAIL_TEXTFIELD
      textField(SIGNIN_EMAIL_TEXTFIELD).value = username
      click on SIGNIN_PASSWORD_TEXTFIELD
      pwdField(SIGNIN_PASSWORD_TEXTFIELD).value = password
      submit()

      appMainPage
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

      appMainPage
    }
  }
}

