package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{ObjectMapRepository, Selector}

/**
  * Created by dev on 17/12/15.
  */
trait StampleEditorBarComponentSelectors extends ObjectMapRepository {
  val STAMPLE_EDITOR_BAR_SAVE_AND_QUIT_BUTTON: Selector = "stampleEditorBar.saveAndQuitButton"
  val STAMPLE_EDITOR_BAR_SAVE_BUTTON: Selector = "stampleEditorBar.saveButton"
  val STAMPLE_EDITOR_BAR_CANCEL_BUTTON: Selector = "stampleEditorBar.cancelButton"

  val STAMPLE_EDITOR_BAR_VIDEO_EMBEDDED_BUTTON: Selector = "stampleEditorBar.videoEmbeddedButton"
  val STAMPLE_EDITOR_BAR_ATTACHMENT_UPLOAD_BUTTON: Selector = "stampleEditorBar.attachmentUploadButton" // Selector for the thing we click
  val STAMPLE_EDITOR_BAR_ATTACHMENT_UPLOAD_INPUT: Selector = "stampleEditorBar.attachmentUploadInput" // Selector for upload input
  val STAMPLE_EDITOR_BAR_PICTURE_UPLOAD_BUTTON: Selector = "stampleEditorBar.pictureUploadButton" // Selector for upload input
  val STAMPLE_EDITOR_BAR_PICTURE_UPLOAD_INPUT: Selector = "stampleEditorBar.pictureUploadInput" // Selector for upload input
  val STAMPLE_EDITOR_BAR_REMINDER_BUTTON: Selector = "stampleEditorBar.reminderButton"
}
