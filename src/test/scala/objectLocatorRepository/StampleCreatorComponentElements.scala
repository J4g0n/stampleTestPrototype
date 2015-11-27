package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{Selector, ObjectMapRepository}

/**
  * Created by dev on 26/11/15.
  */
trait StampleCreatorComponentElements extends ObjectMapRepository {
  val STAMPLE_CREATOR_TITLE_FIELD: Selector = "stampleCreator.title"
  val STAMPLE_CREATOR_SUMMARY_FIELD: Selector = "stampleCreator.summary"
  val STAMPLE_CREATOR_DESCRIPTION_FIELD: Selector = "stampleCreator.description"
  val STAMPLE_CREATOR_SAVE_BUTTON: Selector = "stampleCreator.saveButton"
  val STAMPLE_CREATOR_REMINDER_BUTTON: Selector = "stampleCreator.reminderButton"
}
