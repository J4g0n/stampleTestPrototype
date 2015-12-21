package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{Serialiser, ObjectMapRepository, MapRepository, Selector}
import com.github.kxbmap.configs.syntax._


/**
  * Created by dev on 18/12/15.
  */
case class Homepage[T] extends Serialiser[T] (
  login: T,
  signup: T
)
trait HomepageSelectors extends MapRepository {
  override val path = "homepage"
  private val homepageSelectors = deserialize[Homepage, String, Selector]//deserializeToCaseClass { _.get[Homepage](path) }
/*  val HOMEPAGE_LOGIN_BUTTON: Selector = homepageSelectors.login
  val HOMEPAGE_SIGNUP_BUTTON: Selector = homepageSelectors.signup*/
}
