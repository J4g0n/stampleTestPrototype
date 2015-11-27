package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{Selector, ObjectMapRepository}

/**
  * Created by dev on 26/11/15.
  */
trait LoginPageElements extends ObjectMapRepository {
  val SIGNIN_EMAIL_TEXTFIELD: Selector = "signin.email"
  val SIGNIN_PASSWORD_TEXTFIELD: Selector = "signin.password"
}
