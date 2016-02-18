package pageObjects.pageObjectsImpl

import objectLocatorRepository.{MoreButtonComponentSelectors, MaximisedStampleComponentSelectors}
import pageObjects.MaximisedStampleComponent
import pageObjects.pageObjectsImpl.pageObjectUtils.BaseComponent

/**
  * Created by dev on 15/12/15.
  */
trait MaximisedStampleComponentImpl {
  this: DatePickerComponentImpl =>

  val maximisedStampleComponent: MaximisedStampleComponent = new DefaultMaximisedStampleComponentImpl

  class DefaultMaximisedStampleComponentImpl extends BaseComponent with MaximisedStampleComponent with MaximisedStampleComponentSelectors with MoreButtonComponentSelectors {
    private def openDropDownMenu: Unit = {
      click on MAXIMISED_STAMPLE_MORE_BUTTON
    }

    private def hoverStample = hover(MAXIMISED_STAMPLE)

    // TODO should return Regexp => Unit to ensure actionName match text and language
    private def doActionOnStample: String => Unit = { actionName =>
      scrollUp
      click on MAXIMISED_STAMPLE_MORE_BUTTON
      click on tryFindElementWithText(MORE_BUTTON_NAME, actionName)
    }

    private def doActionOnComment(n: Int): String => Unit = { actionName =>
      val commentElement = findNthElement(MAXIMISED_STAMPLE_COMMENT, n)
      hover(commentElement)
      click on MAXIMISED_STAMPLE_COMMENT_MORE_BUTTON
      click on tryFindElementWithText(MORE_BUTTON_NAME, actionName)
    }


    def title: String = tryFind(MAXIMISED_STAMPLE_TITLE).text

    def summary: String = tryFind(MAXIMISED_STAMPLE_SUMMARY).text

    def description: String = tryFind(MAXIMISED_STAMPLE_DESCRIPTION).text

    def fileNthAttachedName(n: Int): String = findNthElement(MAXIMISED_STAMPLE_FILE_ATTACHMENT_NAME, n).text

    def getNthTagName(n: Int): String = findNthElement(MAXIMISED_STAMPLE_HASHTAG_TEXT, n).text

    def getNthCommentContent(n: Int): String = findNthElement(MAXIMISED_STAMPLE_COMMENT_CONTENT, n).text

    def setReminder(date: String): Unit = {
      hoverStample
      click on MAXIMISED_STAMPLE_REMINDER_BUTTON

      // TODO maybe use regexp for precise dates
      date match {
        case "today" => datepickerComponent.pickToday
        case "tomorrow" => datepickerComponent.pickTomorrow
        case "inAWeek" => datepickerComponent.pickInAWeek
        case "inAMonth" => datepickerComponent.pickInAMonth
        case "in3Months" => datepickerComponent.pickInThreeMonths
        case "inAYear" => datepickerComponent.pickInAYear
        case _ => throw new Error("Invalid date " + date)
      }
    }

    def setFavorite: Unit = {
      hoverStample
      click on MAXIMISED_STAMPLE_FAVORITE_BUTTON
    }

    def editStample: Unit = doActionOnStample("edit")
    def moveStample: Unit = doActionOnStample("move")
    def unlockStample: Unit = doActionOnStample("unlock")
    def reportStample: Unit = doActionOnStample("report")
    def deleteStample: Unit = doActionOnStample("delete")

    def addComment(comment: String): Unit = {
      click on MAXIMISED_STAMPLE_COMMENT_BUTTON
      pressKeys(comment)
      click on MAXIMISED_STAMPLE_NEW_COMMENT_SAVE_BUTTON
    }

    def editComment(n: Int, text: String): Unit = {
      doActionOnComment(n)("edit")
      fill (MAXIMISED_STAMPLE_COMMENT_EDITOR) withText text
      click on MAXIMISED_STAMPLE_COMMENT_EDITION_SAVE_BUTTON
    }
    def deleteNthComment(n: Int): Unit = {
      doActionOnComment(n)("delete")
      click on MAXIMISED_STAMPLE_CONFIRM_DELETE_BUTTON
    }

    def addHashtag(tagName: String): Unit = {
      click on MAXIMISED_STAMPLE_TAG_BUTTON
      fill (MAXIMISED_STAMPLE_HASHTAG_EDITOR) withText tagName
      pressKeys("\r")
    }

    def deleteNthTag(n: Int): Unit = {
      hover (findNthElement(MAXIMISED_STAMPLE_HASHTAG_TEXT, n))
      click on findNthElement(MAXIMISED_STAMPLE_HASHTAG_DELETE_BUTTON, n)
    }

    def likeStample: Unit = click on MAXIMISED_STAMPLE_LIKE_BUTTON

    def gotoLastEventUserProfile: Unit = click on MAXIMISED_STAMPLE_USER_LAST_EVENT
    def gotoCreatorProfile: Unit = click on MAXIMISED_STAMPLE_CREATOR
    def closeStample: Unit = click on MAXIMISED_STAMPLE_CLOSE_BUTTON


    def descriptionContainsImg: Boolean = exists(MAXIMISED_STAMPLE_DESCRIPTION_PICTURE)
    def descriptionContainsIframe: Boolean = exists(MAXIMISED_STAMPLE_DESCRIPTION_VIDEO)
    def isOpened: Boolean = tryFind(MAXIMISED_STAMPLE).isDisplayed
    def isReminderSet: Boolean = {
      hoverStample
      exists(MAXIMISED_STAMPLE_REMINDER_SET_BUTTON)
    }
  }
}
