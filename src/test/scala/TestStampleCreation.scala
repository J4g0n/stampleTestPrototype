import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}
import pageObjects.HomePage


class TestStampleCreation extends FeatureSpec with GivenWhenThen with Matchers {
  val username: String = "Username"
  val password: String = "Password"
  val title: String = "My custom title"
  val summary: String = "My summary"
  val description: String = "My super duper description"

  info("As a User")
  info("I want to be able to create a new Stample")

  feature("Create Stample") {

    scenario("User create a Stample from timeline using new button") {

      Given("User is connected to Stample")
      val homePage = new HomePage
      homePage.openPage
      val appMainPage = homePage.signInWith(username, password)
      val stampleEditorComponent = appMainPage
        .getNewButton
        .openStampleCreator

      When("User fills stample and save it")
      stampleEditorComponent.fillStample(title, summary, description)
      stampleEditorComponent.saveStample

      Then("stample should appear on timeline")
      assert(appMainPage.getTimelineFirstStample.getTitle == title)
    }

    /*scenario("User sign from his mobile") {

    }*/
  }
}
