package utils

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
  with MainContentComponentImpl
  with NewButtonComponentImpl
  with DatePickerComponentImpl
  with VideoEmbeddedPopUpComponentImpl
  with MaximisedStampleComponentImpl
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
  val mainContent = allObjects.mainContent
  val stampleCreator = allObjects.stampleCreatorComponent
  val datePicker = allObjects.datepickerComponent
}


trait StampleMaximisedComponents extends StamplePages {
  private val allObjects = AllObjects.allObjects

  val maximisedStample = allObjects.maximisedStampleComponent

  val navigationBar = allObjects.navigationBarComponent
  val mainContent = allObjects.mainContent
}

trait StampleCreationComponents extends StamplePages {
  private val allObjects = AllObjects.allObjects

  val newButton = allObjects.newButtonComponent
  val stampleCreator = allObjects.stampleCreatorComponent

  // TODO Used for verification maybe it should change
  val navigationBar = allObjects.navigationBarComponent
  val maximisedStample = allObjects.maximisedStampleComponent
  val mainContent = allObjects.mainContent
}

trait NavigationComponents extends StamplePages {
  private val allObjects = AllObjects.allObjects

  val navigationBar = allObjects.navigationBarComponent
  val mainContent = allObjects.mainContent
}
