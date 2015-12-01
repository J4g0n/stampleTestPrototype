package pageObjects

import pageObjects.pageObjectUtils.BasePage
import testConfig.TestConfig


class AppMainPage extends BasePage(TestConfig.baseUrl) {
  val STAMPLE_APP_ROOT_NODE = id("reactAppContainer")

  def stampleRootDisplayed = STAMPLE_APP_ROOT_NODE.element.isDisplayed

  def getNewButton = {
    new NewButtonComponent
  }

  def getStampleEditor = {
    new StampleCreatorComponent
  }

  def getNavigation = {
    new NavigationBarComponent
  }

  def getTimeline = {
    new TimelineComponent
  }
}

