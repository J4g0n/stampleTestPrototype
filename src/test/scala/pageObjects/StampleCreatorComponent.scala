package pageObjects

import objectLocatorRepository.StampleCreatorComponentElements

/**
  * Created by dev on 26/11/15.
  */
class StampleCreatorComponent extends AppMainPage with StampleCreatorComponentElements {
  def fillStample(title: String, summary: String, description: String) = {
    fill (STAMPLE_CREATOR_TITLE_FIELD) withText title
    fill (STAMPLE_CREATOR_SUMMARY_FIELD) withText summary
    fill (STAMPLE_CREATOR_DESCRIPTION_FIELD) withText description
  }

  def saveStample = click on STAMPLE_CREATOR_SAVE_BUTTON

  def openReminder = click on STAMPLE_CREATOR_REMINDER_BUTTON
}
