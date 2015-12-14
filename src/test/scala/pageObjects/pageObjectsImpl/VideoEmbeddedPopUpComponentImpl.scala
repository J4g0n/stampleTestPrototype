package pageObjects.pageObjectsImpl

import objectLocatorRepository.VideoEmbeddedPopUpComponentSelectors
import pageObjects.VideoEmbeddedPopUpComponent
import pageObjects.pageObjectsImpl.pageObjectUtils.BaseComponent

/**
  * Created by dev on 26/11/15.
  */
trait VideoEmbeddedPopUpComponentImpl {
  val videoEmbeddedComponent: VideoEmbeddedPopUpComponent = new DefaultVideoEmbeddedPopUpComponentImpl

  class DefaultVideoEmbeddedPopUpComponentImpl extends BaseComponent with VideoEmbeddedPopUpComponent with VideoEmbeddedPopUpComponentSelectors {
    def addUrl(url: String): Unit = {
      fillUrl(url)
      save
    }

    private def fillUrl(url: String): Unit = {
      click on VIDEO_EMBEDDED_URL_FIELD
      textField(VIDEO_EMBEDDED_URL_FIELD).value = url
    }

    private def cancel: Unit = {
      click on VIDEO_EMBEDDED_CANCEL_BUTTON
    }

    private def save: Unit = {
      click on VIDEO_EMBEDDED_SAVE_BUTTON
    }
  }
}