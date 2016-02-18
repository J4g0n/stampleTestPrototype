package pageObjects.pageObjectsImpl.pageObjectUtils

import scala.util.{Failure, Success, Try}

import objectLocatorRepository.objectMapUtils._
import org.openqa.selenium.{JavascriptExecutor, WebDriver}
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.scalatest.selenium.WebBrowser
import config.TestConfig


trait WebBrowserCustom extends WebBrowser {
  implicit val webDriver: WebDriver = TestConfig.webDriver

  def scrollDown(implicit webDriver: WebDriver) = {
    webDriver.asInstanceOf[JavascriptExecutor].executeScript("window.scrollTo(0,document.body.scrollHeight);")
  }

  def scrollUp(implicit webDriver: WebDriver) = {
    webDriver.asInstanceOf[JavascriptExecutor].executeScript("window.scrollTo(0,-document.body.scrollHeight);")
  }

  def scrollHeight(height: Int)(implicit webDriver: WebDriver) = {
    webDriver.asInstanceOf[JavascriptExecutor].executeScript("window.scrollTo(0," + height + ");")
  }

  private def waitExplicitly(element: Element) = {
    val wait = new WebDriverWait(webDriver, 20)
    wait.until(ExpectedConditions.visibilityOf(element.underlying))
  }

  def safeClick(element: Element)(implicit webDriver: WebDriver): Unit = {
    val action = new Actions(webDriver)
    action
      .moveToElement(element.underlying)
      .click
      .perform
  }

  def tryFind(query: this.Query)(implicit webDriver: WebDriver) = {
    find(query).getOrElse(throw new Error ("Component with query selector: " + query + " doesn't exists, check if it matches something on the interface"))
  }

  // TODO there is somethign that can be wrong with this because we return false when there is no element but query selector can be wrong
  def exists(query: this.Query): Boolean = find(query) match {
    case Some(_) => true
    case None => false
  }

  def hover(element: Element)(implicit webDriver: WebDriver): Unit = {
    val action = new Actions(webDriver)
    action
      .moveToElement(element.underlying)
      .perform
  }

  def hover(s: this.Query)(implicit webDriver: WebDriver): Unit = {
    val selector = tryFind(s)
    hover(selector)
  }

  def findNthElement(s: this.Query, n: Int)(implicit webDriver: WebDriver): this.Element = {
    Try {
        Thread.sleep(2000)
        val elements = findAll(s)
        elements.drop(n).next
      } match {
        case Failure(error) => throw new Error(s"Fail to find $n-th ${s.queryString} element with error: \n$error")
        case Success(element) => element
      }
  }

  def tryFindElementWithText(s: this.Query, actionName: String)(implicit webDriver: WebDriver): this.Element = findAll(s).find(_.text.toLowerCase == actionName).getOrElse(throw new Error("Impossible to get by text element for query: " + s + " and text " + actionName))

  def tryClear(query: this.Query)(implicit webDriver: WebDriver): Unit = {
    find(query)
      .map(_.underlying.clear)
      .getOrElse(throw new Error("An error occur while trying to upload, it seems that selector: " + query + " doesn't match"))
  }

  def handleUpload(query: this.Query, filepath: String)(implicit webDriver: WebDriver): Unit = {
    click on query
    fill(query) withText filepath
  }

  class fill(s: this.Query) {
    def withText(content: String)(implicit webDriver: WebDriver): Unit = {
      click on s
      pressKeys(content)
    }
  }
  object fill {
    def apply(s: Query) = new fill(s)
  }

  implicit def getLocator(selector: Selector): this.Query = {
    val selectedElement = selector match {
      case IdSelector(selectorId) => id(selectorId)
      case CssSelector(selectorCss) => cssSelector(selectorCss)
      case XPathSelector(selectorXPath) => xpath(selectorXPath)
      case ClassSelector(selectorClass) => className(selectorClass)
      case _ => throw new Error("Invalid selector type. Currently selectors allowed are: 'css' and 'id'")
    }

    selectedElement
  }
}

