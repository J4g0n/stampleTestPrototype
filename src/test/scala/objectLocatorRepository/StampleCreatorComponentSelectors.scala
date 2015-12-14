package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{Selector, ObjectMapRepository}

/**
  * Created by dev on 26/11/15.
  */
trait StampleCreatorComponentSelectors extends ObjectMapRepository {
  val STAMPLE_CREATOR_TITLE_FIELD: Selector = "stampleCreator.title"
  val STAMPLE_CREATOR_SUMMARY_FIELD: Selector = "stampleCreator.summary"
  val STAMPLE_CREATOR_DESCRIPTION_FIELD: Selector = "stampleCreator.description"
  val STAMPLE_CREATOR_SAVE_BUTTON: Selector = "stampleCreator.saveButton"
  val STAMPLE_CREATOR_REMINDER_BUTTON: Selector = "stampleCreator.reminderButton"
  val STAMPLE_CREATOR_VIDEO_EMBEDDED_BUTTON: Selector = "stampleCreator.videoEmbeddedButton"
  val STAMPLE_CREATOR_FILE_UPLOAD_BUTTON: Selector = "stampleCreator.fileUploadButton" // Selector for the thing we click
  val STAMPLE_CREATOR_FILE_UPLOAD_INPUT: Selector = "stampleCreator.fileUploadInput" // Selector for upload input
}
