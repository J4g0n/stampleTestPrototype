import org.scalatest.{FeatureSpec, Matchers, GivenWhenThen}
import pageObjects.StampleHomePage
import testConfig.TestConfig


class StampleHomePageTest extends FeatureSpec with GivenWhenThen with Matchers {
  val username: String = "Username"
  val password: String = "Password"
  val baseUrl: String = TestConfig.baseUrl

  info("As a Stample User")
  info("I want to be able to sign in to Stample")
  info("So i can start using Stample")
  info("On desktop and mobile devices as well")

  feature("Sign in") {

    scenario("User sign in from homepage") {

      Given("User connect to the Stample homepage")
      val stampleHomePage = new StampleHomePage
      stampleHomePage.openPage
      assert(stampleHomePage.isCurrentUrlEqualsTo(baseUrl + "login")) // We could use assert too, dunno which one is clearer

      When("User fills sign in form and submit")
      val stampleApp = stampleHomePage.signInWith(username, password)

      Then("User should have access to its content on Stample")
      stampleApp.stampleRootDisplayed
    }

/*    scenario("User sign from his mobile") {

    }*/
  }
}
