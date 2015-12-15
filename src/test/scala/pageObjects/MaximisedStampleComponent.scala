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

  def descriptionContainsImg: Boolean
  def descriptionContainsIframe: Boolean
  def isReminderSet: Boolean
}
