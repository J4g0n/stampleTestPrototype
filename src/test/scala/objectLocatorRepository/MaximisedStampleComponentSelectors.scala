package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{Selector, ObjectMapRepository}

/**
  * Created by dev on 15/12/15.
  */
trait MaximisedStampleComponentSelectors extends ObjectMapRepository {
  val MAXIMISED_STAMPLE_TITLE: Selector = "maximisedStample.title"
  val MAXIMISED_STAMPLE_SUMMARY: Selector = "maximisedStample.summary"
  val MAXIMISED_STAMPLE_DESCRIPTION: Selector = "maximisedStample.description"
  val MAXIMISED_STAMPLE_DESCRIPTION_PICTURE: Selector = "maximisedStample.description.picture"
  val MAXIMISED_STAMPLE_DESCRIPTION_VIDEO: Selector = "maximisedStample.description.video"
  val MAXIMISED_STAMPLE_FILE_ATTACHMENT_NAME: Selector = "maximisedStample.fileAttachmentName"
  val MAXIMISED_STAMPLE_REMINDER_BUTTON: Selector = "maximisedStample.reminder"
  val MAXIMISED_STAMPLE_REMINDER_SET_BUTTON: Selector = "maximisedStample.reminderSet"
}
