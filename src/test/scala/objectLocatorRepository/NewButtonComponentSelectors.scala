package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{Selector, ObjectMapRepository}

/**
  * Created by dev on 26/11/15.
  */
trait NewButtonComponentSelectors extends ObjectMapRepository {
  val NEW_STAMPLE: Selector = "newButton.stample"
}
