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
  val STAMPLE_CREATOR_HASHTAG_REMOVE_BUTTON: Selector = "stampleCreator.hashtagRemove"
}
