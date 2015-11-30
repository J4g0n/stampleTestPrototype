package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{Selector, ObjectMapRepository}

/**
  * Created by dev on 26/11/15.
  */
trait HomePageSelectors extends ObjectMapRepository {
  val HOMEPAGE_LOGIN_BUTTON: Selector = "homepage.login"
  val HOMEPAGE_SIGNUP_BUTTON: Selector = "homepage.signup"
}
