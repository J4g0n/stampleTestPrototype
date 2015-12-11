package testUtils

import pageObjects.pageObjectsImpl._


/**
  * Created by dev on 04/12/15.
  */

class AllObjects
  extends AppMainPageImpl
  with HomePageImpl
  with NavigationBarComponentImpl
  with StampleCreatorComponentImpl
  with TimelineComponentImpl
  with NewButtonComponentImpl
  with DatePickerComponentImpl
object AllObjects {
  val allObjects = new AllObjects
}


trait StamplePages {
  private val allObjects = AllObjects.allObjects

  val mainPage = allObjects.appMainPage
  val homePage = allObjects.homePage
}

trait AllComponents {
  private val allObjects = AllObjects.allObjects

  val navigationBar = allObjects.navigationBarComponent
  val newButton = allObjects.newButtonComponent
  val timeline = allObjects.timelineComponent
  val stampleCreator = allObjects.stampleCreatorComponent
  val datePicker = allObjects.datepickerComponent
}


trait StampleCreationComponents extends StamplePages {
  private val allObjects = AllObjects.allObjects

  val newButton = allObjects.newButtonComponent
  val stampleCreator = allObjects.stampleCreatorComponent
  val datePicker = allObjects.datepickerComponent
}

trait NavigationComponents extends StamplePages {
  private val allObjects = AllObjects.allObjects
  
  val navigationBar = allObjects.navigationBarComponent
  val timeline = allObjects.timelineComponent
}

