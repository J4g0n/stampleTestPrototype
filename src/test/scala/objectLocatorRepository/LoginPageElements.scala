package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.ObjectMapRepository
import org.scalatest.selenium.WebBrowser

/**
  * Created by dev on 26/11/15.
  */
trait LoginPageElements extends ObjectMapRepository {
  this: WebBrowser =>

  val SIGNIN_EMAIL_TEXTFIELD: Selector = "signin.email"
  val SIGNIN_PASSWORD_TEXTFIELD: Selector = "signin.password"
}
