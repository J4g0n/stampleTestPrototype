package pageObjects.pageObjectsImpl

import objectLocatorRepository.StampleCreatorComponentSelectors
import pageObjects.StampleCreatorComponent
import pageObjects.pageObjectUtils.BaseComponent

/**
  * Created by dev on 26/11/15.
  */
trait StampleCreatorComponentImpl {
  val stampleCreatorComponent: StampleCreatorComponent = new DefaultStampleCreatorComponentImpl

  class DefaultStampleCreatorComponentImpl extends BaseComponent with StampleCreatorComponent with StampleCreatorComponentSelectors {
    def fillStample(title: String, summary: String, description: String) = {
      fill(STAMPLE_CREATOR_TITLE_FIELD) withText title
      fill(STAMPLE_CREATOR_SUMMARY_FIELD) withText summary
      fill(STAMPLE_CREATOR_DESCRIPTION_FIELD) withText description
    }

    def saveStample = click on STAMPLE_CREATOR_SAVE_BUTTON

    def addReminder = {
      click on STAMPLE_CREATOR_REMINDER_BUTTON
      /*val datePicker = new DatePickerComponent
      datePicker.choseDate("15/06/2016")*/
    }
  }
}