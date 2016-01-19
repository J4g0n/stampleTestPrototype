package pageObjects

/**
  * Created by dev on 04/12/15.
  */
trait Page {
  def openPage: Page

  def closePage: Unit

  def quitBrowser: Unit

  def getCurrentUrl: String
}
