package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.ObjectMapRepository
import org.scalatest.selenium.WebBrowser

/**
  * Created by dev on 26/11/15.
  */
trait HomePageElements extends ObjectMapRepository {
  this: WebBrowser =>

  val HOMEPAGE_LOGIN_BUTTON: Selector = "homepage.login"
  val HOMEPAGE_SIGNUP_BUTTON: Selector = "homepage.signup"
}
