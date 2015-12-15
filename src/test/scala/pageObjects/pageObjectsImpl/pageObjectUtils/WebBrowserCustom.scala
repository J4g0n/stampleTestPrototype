package pageObjects.pageObjectsImpl.pageObjectUtils

import objectLocatorRepository.objectMapUtils._
import org.openqa.selenium.support.ui.{WebDriverWait, ExpectedConditions}
import org.openqa.selenium.{JavascriptExecutor, WebDriver}
import org.openqa.selenium.interactions.Actions
import org.scalatest.selenium.WebBrowser
import testConfig.TestConfig


trait WebBrowserCustom extends WebBrowser {
  implicit val webDriver: WebDriver = TestConfig.webDriver

  def scrollToTop(implicit webDriver: WebDriver) = {
    webDriver.asInstanceOf[JavascriptExecutor].executeScript("window.scrollTo(0,document.body.scrollHeight);")
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

  def findNthElement(s: this.Query, n: Int)(implicit webDriver: WebDriver): this.Element = findAll(s).drop(n).next

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
    //new WebDriverWait(webDriver, 30).until(ExpectedConditions.visibilityOfElementLocated(selectedElement.by))

    selectedElement
  }
}

