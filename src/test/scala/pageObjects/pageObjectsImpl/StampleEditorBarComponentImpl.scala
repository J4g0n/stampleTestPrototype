package pageObjects.pageObjectsImpl

import objectLocatorRepository.StampleEditorBarComponentSelectors
import pageObjects.StampleEditorBarComponent
import pageObjects.pageObjectsImpl.pageObjectUtils.BaseComponent

/**
  * Created by dev on 17/12/15.
  */
trait StampleEditorBarComponentImpl {
  this: DatePickerComponentImpl
    with VideoEmbeddedPopUpComponentImpl =>

  val editorBarComponent: StampleEditorBarComponent = new DefaultStampleEditorBarComponentImpl

  class DefaultStampleEditorBarComponentImpl extends BaseComponent with StampleEditorBarComponent with StampleEditorBarComponentSelectors {
    def saveStample: Unit = click on STAMPLE_EDITOR_BAR_SAVE_BUTTON

    def saveAndQuitStample: Unit = click on STAMPLE_EDITOR_BAR_SAVE_AND_QUIT_BUTTON

    def cancelEdition: Unit = click on STAMPLE_EDITOR_BAR_CANCEL_BUTTON

    def addReminder(date: String): Unit = {
      click on STAMPLE_EDITOR_BAR_REMINDER_BUTTON
      datepickerComponent.pickDate(date)
    }

    def addPhoto(photoname: String): Unit = handleUpload(STAMPLE_EDITOR_BAR_PICTURE_UPLOAD_INPUT, photoname)

    def addFile(filename: String): Unit = handleUpload(STAMPLE_EDITOR_BAR_ATTACHMENT_UPLOAD_INPUT, filename)

    def addEmbeddedVideo(videoUrl: String): Unit = {
      click on STAMPLE_EDITOR_BAR_VIDEO_EMBEDDED_BUTTON
      videoEmbeddedComponent.addUrl(videoUrl)
    }
  }
}
