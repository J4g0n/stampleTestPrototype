package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{ObjectMapRepository, Selector}

/**
  * Created by dev on 16/12/15.
  */
trait MoreButtonComponentSelectors extends ObjectMapRepository {
  val MORE_BUTTON_NAME: Selector = "moreButton.name"
}
