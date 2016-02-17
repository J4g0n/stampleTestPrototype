package pageObjects


/**
  * Created by dev on 26/11/15.
  */
trait StampleCreatorComponent {
  def isOpened: Boolean

  def fillStample(title: String, summary: String, description: String): Unit

  def saveStample: Unit

  def addReminder(date: String): Unit

  def addPhoto(filename: String): Unit

  def addFile(filename: String): Unit

  def addComment(comment: String): Unit

  def addHashtag(hashtag: String): Unit

  def removeNthTag(n: Int): Unit

  def addEmbeddedVideo(videoUrl: String): Unit

  def changeFolder(date: String): Unit
}
