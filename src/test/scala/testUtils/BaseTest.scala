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
  val mainPage = BaseTest.pageObjects.appMainPage
  val homePage = BaseTest.pageObjects.homePage
  val navigationBar = BaseTest.pageObjects.navigationBarComponent
  val newButton = BaseTest.pageObjects.newButtonComponent
  val timeline = BaseTest.pageObjects.timelineComponent
  val stampleCreator = BaseTest.pageObjects.stampleCreatorComponent
}
object BaseTest {
  val pageObjects = new PageObjects
}
