package pageObjects.pageObjectsImpl

import objectLocatorRepository.StampleCreatorComponentSelectors
import pageObjects.StampleCreatorComponent
import pageObjects.pageObjectsImpl.pageObjectUtils.BaseComponent

/**
  * Created by dev on 26/11/15.
  */
trait StampleCreatorComponentImpl {
  this: DatePickerComponentImpl
    with VideoEmbeddedPopUpComponentImpl =>

  val stampleCreatorComponent: StampleCreatorComponent = new DefaultStampleCreatorComponentImpl

  class DefaultStampleCreatorComponentImpl extends BaseComponent with StampleCreatorComponent with StampleCreatorComponentSelectors {
    def isOpened: Boolean = tryFind(STAMPLE_CREATOR).isDisplayed

    def fillStample(title: String, summary: String, description: String) = {
      fill(STAMPLE_CREATOR_TITLE_FIELD) withText title
      fill(STAMPLE_CREATOR_SUMMARY_FIELD) withText summary
      fill(STAMPLE_CREATOR_DESCRIPTION_FIELD) withText description
    }

    def addComment(comment: String): Unit = fill(STAMPLE_CREATOR_COMMENT_FIELD) withText comment

    def addHashtag(hashtag: String): Unit = {
      find(STAMPLE_CREATOR_HASHTAG_BUTTON).map(click on _)
      fill(STAMPLE_CREATOR_HASHTAG_FIELD) withText hashtag
      pressKeys(" ") // TODO mandatory to save hashtag it's also possible to use ENTER (just dunno its code)
    }

    def removeNthTag(n: Int): Unit = {
      val tagRemoveButton = findNthElement(STAMPLE_CREATOR_HASHTAG_REMOVE_BUTTON, n)
      hover(tagRemoveButton)
      click on tagRemoveButton
    }

    def toggleMaximisedView: Unit = click on STAMPLE_CREATOR_STRETCH_BUTTON

    def changeFolder(date: String): Unit = {

    }
  }
}