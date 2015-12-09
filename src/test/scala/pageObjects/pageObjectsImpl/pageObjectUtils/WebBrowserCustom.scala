package pageObjects.pageObjectsImpl.pageObjectUtils

import objectLocatorRepository.objectMapUtils._
import org.openqa.selenium.{JavascriptExecutor, WebDriver}
import org.openqa.selenium.interactions.Actions
import org.scalatest.selenium.WebBrowser
import testConfig.TestConfig


trait WebBrowserCustom extends WebBrowser {
  implicit val webDriver: WebDriver = TestConfig.webDriver

  def scrollToTop(implicit webDriver: WebDriver) = {
    webDriver.asInstanceOf[JavascriptExecutor].executeScript("window.scrollTo(0,document.body.scrollHeight);")
  }

  def hover(element: Element)(implicit webDriver: WebDriver): Unit = {
    val action = new Actions(webDriver)
    action.moveToElement(element.underlying).perform()
  }

  def hover(s: this.Query)(implicit webDriver: WebDriver): Unit = {
    val selector = find(s).get // TODO catch exceptions here
    hover(selector)
  }

  def findNthElement(s: this.Query, n: Int)(implicit webDriver: WebDriver): this.Element = {
    findAll(s).drop(n).next
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
    //new WebDriverWait(webDriver, 30).until(ExpectedConditions.visibilityOfElementLocated(selectedElement.by))

    selectedElement
  }
}

