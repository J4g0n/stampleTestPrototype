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

    def saveStample = click on STAMPLE_CREATOR_SAVE_BUTTON

    def addReminder(date: String) = {
      click on STAMPLE_CREATOR_REMINDER_BUTTON

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

    def addPhoto(photoname: String): Unit = handleUpload(STAMPLE_CREATOR_PICTURE_UPLOAD_INPUT, photoname)

    def addFile(filename: String): Unit = handleUpload(STAMPLE_CREATOR_ATTACHMENT_UPLOAD_INPUT, filename)

    def addComment(comment: String): Unit = fill(STAMPLE_CREATOR_COMMENT_FIELD) withText comment

    def addHashtag(hashtag: String): Unit = {
      find(STAMPLE_CREATOR_HASHTAG_BUTTON).map(click on _)
      fill(STAMPLE_CREATOR_HASHTAG_FIELD) withText hashtag
      pressKeys("\r")
    }

    def removeNthTag(n: Int): Unit = {
      val tagRemoveButton = findNthElement(STAMPLE_CREATOR_HASHTAG_REMOVE_BUTTON, n)
      hover(tagRemoveButton)
      click on tagRemoveButton
    }

    def toggleMaximisedView: Unit = click on STAMPLE_CREATOR_STRETCH_BUTTON

    def addEmbeddedVideo(videoUrl: String): Unit = {
      click on STAMPLE_CREATOR_VIDEO_EMBEDDED_BUTTON
      videoEmbeddedComponent.addUrl(videoUrl)
    }

    def changeFolder(date: String): Unit = {

    }
  }
}