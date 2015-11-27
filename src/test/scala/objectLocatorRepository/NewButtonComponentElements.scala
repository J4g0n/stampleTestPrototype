package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{Selector, ObjectMapRepository}

/**
  * Created by dev on 26/11/15.
  */
trait NewButtonComponentElements extends ObjectMapRepository {
  val NEW_BUTTON: Selector = "new.button"
  val NEW_STAMPLE: Selector = "new.stample"
}
