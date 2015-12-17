package pageObjects


/**
  * Created by dev on 26/11/15.
  */
trait StampleCreatorComponent {
  def isOpened: Boolean

  def fillStample(title: String, summary: String, description: String): Unit

  def addComment(comment: String): Unit

  def addHashtag(hashtag: String): Unit

  def removeNthTag(n: Int): Unit

  def toggleMaximisedView: Unit

  def changeFolder(date: String): Unit
}
