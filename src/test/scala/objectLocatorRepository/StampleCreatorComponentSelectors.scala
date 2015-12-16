package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{Selector, ObjectMapRepository}

/**
  * Created by dev on 26/11/15.
  */
trait StampleCreatorComponentSelectors extends ObjectMapRepository {
  val STAMPLE_CREATOR: Selector = "stampleCreator"
  val STAMPLE_CREATOR_TITLE_FIELD: Selector = "stampleCreator.title"
  val STAMPLE_CREATOR_SUMMARY_FIELD: Selector = "stampleCreator.summary"
  val STAMPLE_CREATOR_DESCRIPTION_FIELD: Selector = "stampleCreator.description"
  val STAMPLE_CREATOR_COMMENT_FIELD: Selector = "stampleCreator.comment"
  val STAMPLE_CREATOR_HASHTAG_BUTTON: Selector = "stampleCreator.hashtagButton"
  val STAMPLE_CREATOR_HASHTAG_FIELD: Selector = "stampleCreator.hashtag"
  val STAMPLE_CREATOR_STRETCH_BUTTON: Selector = "stampleCreator.stretchButton"
  val STAMPLE_CREATOR_SAVE_BUTTON: Selector = "stampleCreator.saveButton"
  val STAMPLE_CREATOR_REMINDER_BUTTON: Selector = "stampleCreator.reminderButton"
  val STAMPLE_CREATOR_HASHTAG_REMOVE_BUTTON: Selector = "stampleCreator.hashtagRemove"
  val STAMPLE_CREATOR_VIDEO_EMBEDDED_BUTTON: Selector = "stampleCreator.videoEmbeddedButton"
  val STAMPLE_CREATOR_ATTACHMENT_UPLOAD_BUTTON: Selector = "stampleCreator.attachmentUploadButton" // Selector for the thing we click
  val STAMPLE_CREATOR_ATTACHMENT_UPLOAD_INPUT: Selector = "stampleCreator.attachmentUploadInput" // Selector for upload input
  val STAMPLE_CREATOR_PICTURE_UPLOAD_BUTTON: Selector = "stampleCreator.pictureUploadButton" // Selector for upload input
  val STAMPLE_CREATOR_PICTURE_UPLOAD_INPUT: Selector = "stampleCreator.pictureUploadInput" // Selector for upload input
}
