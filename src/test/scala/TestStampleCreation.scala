import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}
import pageObjects.{NewButtonComponent, HomePage}
import testConfig.TestConfig


class TestStampleCreation extends FeatureSpec with GivenWhenThen with Matchers {
  val username: String = "Username"
  val password: String = "Password"

  info("As a User")
  info("I want to be able to create a new Stample")

  feature("Create Stample") {

    scenario("User create a Stample from timeline using new button") {

      Given("User is connected to Stample")
      val homePage = new HomePage
      homePage.openPage
      homePage.signInWith(username, password)
      val newButtonComponent = new NewButtonComponent
      newButtonComponent.openStampleCreator

      When("User fills sign in form and submit")

      Then("User should have access to its content on Stample")
    }

    /*    scenario("User sign from his mobile") {

        }*/
  }
}
