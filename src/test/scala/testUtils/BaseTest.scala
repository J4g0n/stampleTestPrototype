package testUtils

import pageObjects.pageObjectsImpl._


/**
  * Created by dev on 04/12/15.
  */

class PageObjects
  extends AppMainPageImpl
  with HomePageImpl
  with NavigationBarComponentImpl
  with StampleCreatorComponentImpl
  with TimelineComponentImpl
  with NewButtonComponentImpl


trait BaseTest {
  private val pageObjects = BaseTest.pageObjects

  val mainPage = pageObjects.appMainPage
  val homePage = pageObjects.homePage
  val navigationBar = pageObjects.navigationBarComponent
  val newButton = pageObjects.newButtonComponent
  val timeline = pageObjects.timelineComponent
  val stampleCreator = pageObjects.stampleCreatorComponent
}
object BaseTest {
  val pageObjects = new PageObjects
}

