package pageObjects.pageObjectsImpl

import pageObjects.AppMainPage


trait AppMainPageImpl {
  self: NewButtonComponentImpl
    with HomePageImpl
    with StampleCreatorComponentImpl
    with NavigationBarComponentImpl
    with TimelineComponentImpl =>

  val appMainPage: AppMainPage = new DefaultAppMainPageImpl

  class DefaultAppMainPageImpl extends AppMainPage {
    private val STAMPLE_APP_ROOT_NODE = id("reactAppContainer")

    def openPage(username: String, password: String) = {
      homePage.openPage.signInWith(username, password)
    }

    def stampleRootDisplayed = STAMPLE_APP_ROOT_NODE.element.isDisplayed

    def getNewButton = newButtonComponent

    def getStampleEditor = stampleCreatorComponent

    def getNavigation = navigationBarComponent

    def getTimeline = timelineComponent
  }
}

