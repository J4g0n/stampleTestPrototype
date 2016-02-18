package pageObjects.pageObjectsImpl

import pageObjects.AppMainPage
import pageObjects.pageObjectsImpl.pageObjectUtils.BasePage
import config.TestConfig


trait AppMainPageImpl {
  self: NewButtonComponentImpl
    with HomePageImpl
    with StampleCreatorComponentImpl
    with NavigationBarComponentImpl
    with MainContentComponentImpl =>

  val appMainPage: AppMainPage = new DefaultAppMainPageImpl

  class DefaultAppMainPageImpl extends BasePage(TestConfig.baseUrl) with AppMainPage {
    private val STAMPLE_APP_ROOT_NODE = id("reactAppContainer")

    def openPage(username: String, password: String) = {
      homePage.openPage
      homePage.signInWith(username, password)
    }

    def stampleRootDisplayed = STAMPLE_APP_ROOT_NODE.element.isDisplayed
  }
}

