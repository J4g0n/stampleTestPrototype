package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{ObjectMapRepository, MapRepository, Selector}
import com.github.kxbmap.configs.syntax._


/**
  * Created by dev on 18/12/15.
  */
case class Homepage (
  login: String,
  signup: String
)
trait HomepageSelectors extends MapRepository[Homepage] {
  override val path = "homepage"
  private val homepageSelectors: Homepage = deserializeToCaseClass { _.get[Homepage](path) }

  val HOMEPAGE_LOGIN_BUTTON: Selector = homepageSelectors.login
  val HOMEPAGE_SIGNUP_BUTTON: Selector = homepageSelectors.signup
}
