package pageObjects.pageObjectsImpl

import objectLocatorRepository.NewButtonComponentSelectors
import pageObjects.NewButtonComponent
import pageObjects.pageObjectsImpl.pageObjectUtils.BaseComponent

/**
  * Created by dev on 26/11/15.
  */
trait NewButtonComponentImpl {
  self: StampleCreatorComponentImpl =>

  val newButtonComponent: NewButtonComponent = new DefaultNewButtonComponentImpl

  class DefaultNewButtonComponentImpl extends BaseComponent with NewButtonComponent with NewButtonComponentSelectors {
    def openStampleCreator = {
      click on NEW_STAMPLE
    }
  }
}
