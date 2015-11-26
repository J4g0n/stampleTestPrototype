package objectLocatorRepository

import org.scalatest.selenium.WebBrowser

/**
  * Created by dev on 26/11/15.
  */
trait HomePageElements extends ObjectMapRepository {
  this: WebBrowser =>

  val LOGIN_BUTTON: this.Query = "homepage.loginButton"
  val EMAIL_SIGNIN_TEXTFIELD: this.Query = "homepage.signInText"
  val PASSWORD_SIGNIN_TEXTFIELD: this.Query = "homepage.signInPassword"
}
