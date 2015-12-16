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

    private def hoverStample = hover(MAXIMISED_STAMPLE_TITLE)

    private def doAction: String => Unit = { actionName =>
      hoverStample
      click on MAXIMISED_STAMPLE_MORE_BUTTON
      click on tryFindElementWithText(MORE_BUTTON_NAME, actionName)
      click on MAXIMISED_STAMPLE_MORE_BUTTON
    }


    def isOpened: Boolean = tryFind(MAXIMISED_STAMPLE).isDisplayed

    def title: String = tryFind(MAXIMISED_STAMPLE_TITLE).text

    def summary: String = tryFind(MAXIMISED_STAMPLE_SUMMARY).text

    def description: String = tryFind(MAXIMISED_STAMPLE_DESCRIPTION).text

    def fileNthAttachedName(n: Int): String = findNthElement(MAXIMISED_STAMPLE_FILE_ATTACHMENT_NAME, n).text

    def getNthTagName(n: Int): String = findNthElement(MAXIMISED_STAMPLE_HASHTAG_TEXT, n).text

    def getNthComment(n: Int): String = findNthElement(MAXIMISED_STAMPLE_COMMENT, n).text

    def descriptionContainsImg: Boolean = exists(MAXIMISED_STAMPLE_DESCRIPTION_PICTURE)

    def descriptionContainsIframe: Boolean = exists(MAXIMISED_STAMPLE_DESCRIPTION_VIDEO)

    def isReminderSet: Boolean = {
      hoverStample
      exists(MAXIMISED_STAMPLE_REMINDER_SET_BUTTON)
    }

    def setReminder(date: String) = {
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
      /*val datePicker = new DatePickerComponent
      datePicker.choseDate("15/06/2016")*/
    }

    def setFavorite: Unit = {
      hoverStample
      click on MAXIMISED_STAMPLE_FAVORITE_BUTTON
    }

    def editStample: Unit = doAction("edit")

    def moveStample: Unit = doAction("move")

    def unlockStample: Unit = doAction("unlock")

    def reportStample: Unit = doAction("report")

    def deleteStample: Unit = doAction("delete")
  }
}
