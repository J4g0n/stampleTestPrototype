package pageObjects

/**
  * Created by dev on 17/12/15.
  */
trait StampleEditorBarComponent {
  def saveStample: Unit
  def saveAndQuitStample: Unit
  def cancelEdition: Unit

  def addReminder(date: String): Unit
  def addPhoto(filename: String): Unit
  def addFile(filename: String): Unit
  def addEmbeddedVideo(videoUrl: String): Unit
}
