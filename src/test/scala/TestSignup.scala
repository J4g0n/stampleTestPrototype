import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}
import testConfig.TestConfig
import testUtils.StamplePages


class TestSignup extends FeatureSpec with GivenWhenThen with Matchers with StamplePages {

  // TODO ensure user doesn't already exist
  private val userNumber = (Math.random() * 1000000).toInt.toString
  val email: String = s"quelquun$userNumber@stample.co"
  val username: String = s"JoDalton$userNumber"
  val firstname: String = "moins"
  val lastname: String = "exunard"
  val password: String = "password"
  val baseUrl: String = TestConfig.baseUrl

  info("As a Visitor")
  info("I want to be able to sign up to Stample")
  info("So i can start using Stample")
  info("On desktop and mobile devices as well")

  feature("Sign up") {

    scenario("User sign up from homepage") {

      Given("User connect to the Stample homepage")
      homePage.openPage

      When("User fills sign in form and submit")
      homePage.signUpWith(email, username, firstname, lastname, password)

      Then("User should have access to its content on Stample")
      mainPage.stampleRootDisplayed
    }

/*    scenario("User sign from his mobile") {

    }*/
  }
}
