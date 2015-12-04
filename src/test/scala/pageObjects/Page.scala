package pageObjects

/**
  * Created by dev on 04/12/15.
  */
trait Page {
  def openPage: Page

  def isCurrentUrlEqualsTo(url: String): Boolean
}
