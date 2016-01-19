package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{ObjectMapRepository, Selector}


/**
  * Created by dev on 18/12/15.
  */
trait HomepageSelectors extends ObjectMapRepository {
  val HOMEPAGE_LOGIN_BUTTON: Selector = "homepage.login"
  val HOMEPAGE_SIGNUP_BUTTON: Selector = "homepage.signup"
}
