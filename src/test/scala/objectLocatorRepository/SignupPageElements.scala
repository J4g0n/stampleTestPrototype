package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.ObjectMapRepository
import org.scalatest.selenium.WebBrowser

/**
  * Created by dev on 26/11/15.
  */
trait SignupPageElements extends ObjectMapRepository {
  this: WebBrowser =>

  val SIGNUP_EMAIL_TEXTFIELD: Selector = "signup.email"
  val SIGNUP_USERNAME_TEXTFIELD: Selector = "signup.username"
  val SIGNUP_FIRSTNAME_TEXTFIELD: Selector = "signup.firstname"
  val SIGNUP_LASTNAME_TEXTFIELD: Selector = "signup.lastname"
  val SIGNUP_PASSWORD_TEXTFIELD: Selector = "signup.password"
  val SIGNUP_ACCEPT_TERMS_BUTTON: Selector = "signup.acceptTerms"
}
