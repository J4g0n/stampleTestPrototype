package pageObjects.pageObjectsImpl

import objectLocatorRepository.NewButtonComponentSelectors
import pageObjects.NewButtonComponent
import pageObjects.pageObjectUtils.BaseComponent

/**
  * Created by dev on 26/11/15.
  */
trait NewButtonComponentImpl {
  self: StampleCreatorComponentImpl =>

  val newButtonComponent: NewButtonComponent = new DefaultNewButtonComponentImpl

  class DefaultNewButtonComponentImpl extends BaseComponent with NewButtonComponent with NewButtonComponentSelectors {
    def openStampleCreator = {
      hover(NEW_BUTTON)
      Thread.sleep(500) // Required because of css animation, that sucks...
      click on NEW_STAMPLE

      stampleCreatorComponent
    }
  }
}
