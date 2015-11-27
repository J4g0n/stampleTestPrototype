package testUtils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions
import org.scalatest.selenium.WebBrowser



class WebBrowserCustom extends WebBrowser {

  def hover(element: Element)(implicit webDriver: WebDriver): Unit = {
    val action = new Actions(webDriver)
    action.moveToElement(element.underlying).perform()
  }

  def hover(s: this.Query)(implicit webDriver: WebDriver): Unit = {
    val selector = find(s).get // TODO catch exceptions here
    hover(selector)
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
}

