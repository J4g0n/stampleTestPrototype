package pageObjects


/**
  * Created by dev on 26/11/15.
  */
trait StampleCreatorComponent {
  def fillStample(title: String, summary: String, description: String): Unit

  def saveStample: Unit

  def addReminder(date: String): Unit

  def addFile(filename: String): Unit

  def addEmbeddedVideo(videoUrl: String): Unit

  def changeFolder(date: String): Unit
}
