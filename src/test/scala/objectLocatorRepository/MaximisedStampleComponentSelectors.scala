package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{Selector, ObjectMapRepository}

/**
  * Created by dev on 15/12/15.
  */
trait MaximisedStampleComponentSelectors extends ObjectMapRepository {
  val MAXIMISED_STAMPLE: Selector = "maximisedStample"
  val MAXIMISED_STAMPLE_TITLE: Selector = "maximisedStample.title"
  val MAXIMISED_STAMPLE_SUMMARY: Selector = "maximisedStample.summary"
  val MAXIMISED_STAMPLE_DESCRIPTION: Selector = "maximisedStample.description"
  val MAXIMISED_STAMPLE_COMMENT: Selector = "maximisedStample.comment"
  val MAXIMISED_STAMPLE_DESCRIPTION_PICTURE: Selector = "maximisedStample.description.picture"
  val MAXIMISED_STAMPLE_DESCRIPTION_VIDEO: Selector = "maximisedStample.description.video"
  val MAXIMISED_STAMPLE_FILE_ATTACHMENT_NAME: Selector = "maximisedStample.fileAttachmentName"
  val MAXIMISED_STAMPLE_REMINDER_BUTTON: Selector = "maximisedStample.reminderButton"
  val MAXIMISED_STAMPLE_FAVORITE_BUTTON: Selector = "maximisedStample.favoriteButton"
  val MAXIMISED_STAMPLE_COMMENT_BUTTON: Selector = "maximisedStample.commentButton"
  val MAXIMISED_STAMPLE_TAG_BUTTON: Selector = "maximisedStample.tagButton"
  val MAXIMISED_STAMPLE_MORE_BUTTON: Selector = "maximisedStample.moreButton"
  val MAXIMISED_STAMPLE_LIKE_BUTTON: Selector = "maximisedStample.likeButton"
  val MAXIMISED_STAMPLE_REMINDER_SET_BUTTON: Selector = "maximisedStample.reminderSet"
  val MAXIMISED_STAMPLE_HASHTAG_TEXT: Selector = "maximisedStample.tagText"
}
