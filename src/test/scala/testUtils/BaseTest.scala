package testUtils

import org.scalatest.{Matchers, GivenWhenThen, FeatureSpec}
import pageObjects.pageObjectsImpl._


/**
  * Created by dev on 04/12/15.
  */
// Setup for specific tests
abstract class BaseTestSetup extends FeatureSpec with GivenWhenThen with Matchers


class AllObjects
  extends AppMainPageImpl
  with HomePageImpl
  with NavigationBarComponentImpl
  with StampleCreatorComponentImpl
  with TimelineComponentImpl
  with NewButtonComponentImpl
  with DatePickerComponentImpl
  with VideoEmbeddedPopUpComponentImpl
  with MaximisedStampleComponentImpl
  with OnBoardingComponentImpl
object AllObjects {
  val allObjects = new AllObjects
}


trait StamplePages extends BaseTestSetup  {
  private val allObjects = AllObjects.allObjects

  val mainPage = allObjects.appMainPage
  val homePage = allObjects.homePage
}

trait AllComponents extends BaseTestSetup {
  private val allObjects = AllObjects.allObjects

  val navigationBar = allObjects.navigationBarComponent
  val newButton = allObjects.newButtonComponent
  val timeline = allObjects.timelineComponent
  val stampleCreator = allObjects.stampleCreatorComponent
  val datePicker = allObjects.datepickerComponent
}


trait StampleMaximisedComponents extends StamplePages {
  private val allObjects = AllObjects.allObjects

  val maximisedStample = allObjects.maximisedStampleComponent

  val navigationBar = allObjects.navigationBarComponent
  val timeline = allObjects.timelineComponent
}

trait OnBoardingComponents extends StamplePages {
  private val allObjects = AllObjects.allObjects

  val onBoarding = allObjects.onBoardingComponent
}

trait StampleCreationComponents extends StamplePages {
  private val allObjects = AllObjects.allObjects

  val newButton = allObjects.newButtonComponent
  val stampleCreator = allObjects.stampleCreatorComponent

  // TODO Used for verification maybe it should change
  val navigationBar = allObjects.navigationBarComponent
  val maximisedStample = allObjects.maximisedStampleComponent
  val timeline = allObjects.timelineComponent
}

trait NavigationComponents extends StamplePages {
  private val allObjects = AllObjects.allObjects

  val onBoarding = allObjects.onBoardingComponent

  val navigationBar = allObjects.navigationBarComponent
  val timeline = allObjects.timelineComponent
}
