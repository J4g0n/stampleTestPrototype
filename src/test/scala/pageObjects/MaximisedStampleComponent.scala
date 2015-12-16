package pageObjects

/**
  * Created by dev on 15/12/15.
  */
trait MaximisedStampleComponent {
  def title: String
  def summary: String
  def description: String
  def fileNthAttachedName(n: Int): String
  def getNthTagName(n: Int): String
  def getNthComment(n: Int): String

  def setReminder(date: String): Unit
  def setFavorite: Unit
  def moveStample: Unit
  def unlockStample: Unit
  def reportStample: Unit
  def deleteStample: Unit
  def editStample: Unit

  def isOpened: Boolean
  def descriptionContainsImg: Boolean
  def descriptionContainsIframe: Boolean
  def isReminderSet: Boolean
}
