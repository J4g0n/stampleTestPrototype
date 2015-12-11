import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}
import testUtils.BaseTest


class TestStampleCreation extends FeatureSpec with GivenWhenThen with Matchers with BaseTest {
  val username: String = "Username2"
  val password: String = "Password"
  val title: String = "My custom title"
  val summary: String = "My pretty summary"
  val description: String = "My super duper description"

  info("As a User")
  info("I want to be able to create a new Stample")

  feature("Create Stample") {

    scenario("User create a Stample from timeline using new button") {

      Given("User is connected to Stample")
      mainPage.openPage(username, password)
      newButton.openStampleCreator

      When("User fills stample and save it")
      stampleCreator.fillStample(title, summary, description)
      stampleCreator.saveStample

      Then("stample should appear on timeline")
      // TODO assert something here that proves Stample has been created
    }

    /*scenario("User sign from his mobile") {

    }*/
  }
}
