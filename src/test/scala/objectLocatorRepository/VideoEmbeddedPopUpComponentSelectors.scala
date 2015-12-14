package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{ObjectMapRepository, Selector}


/**
  * Created by dev on 14/12/15.
  */
trait VideoEmbeddedPopUpComponentSelectors extends ObjectMapRepository {
  val VIDEO_EMBEDDED_CANCEL_BUTTON: Selector = "videoEmbedded.cancel"
  val VIDEO_EMBEDDED_SAVE_BUTTON: Selector = "videoEmbedded.save"
  val VIDEO_EMBEDDED_URL_FIELD: Selector = "videoEmbedded.url"
}
