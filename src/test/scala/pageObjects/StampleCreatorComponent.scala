package pageObjects


/**
  * Created by dev on 26/11/15.
  */
trait StampleCreatorComponent {
  def fillStample(title: String, summary: String, description: String): Unit

  def saveStample: Unit

  def addReminder(date: String): Unit
}
