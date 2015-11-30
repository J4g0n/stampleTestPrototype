package pageObjects

import objectLocatorRepository.NewButtonComponentSelectors

/**
  * Created by dev on 26/11/15.
  */
class NewButtonComponent extends AppMainPage with NewButtonComponentSelectors {
  def openStampleCreator = {
    hover (NEW_BUTTON)
    Thread.sleep(500) // Required because of css animation, that sucks...
    click on NEW_STAMPLE

    new StampleCreatorComponent
  }
}
