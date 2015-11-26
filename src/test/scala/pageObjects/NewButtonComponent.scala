package pageObjects

import objectLocatorRepository.NewButtonComponentElements

/**
  * Created by dev on 26/11/15.
  */
class NewButtonComponent extends AppMainPage with NewButtonComponentElements {
  def openStampleCreator = {
    click on NEW_BUTTON
    click on NEW_STAMPLE

    new StampleCreatorComponent
  }
}
