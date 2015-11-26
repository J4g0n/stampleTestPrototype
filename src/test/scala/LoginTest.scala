import org.scalatest.{FeatureSpec, Matchers, GivenWhenThen}
import pageObjects.HomePage
import testConfig.TestConfig


class LoginTest extends FeatureSpec with GivenWhenThen with Matchers {

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
      val homePage = new HomePage
      homePage.openPage
      assert(homePage.isCurrentUrlEqualsTo(baseUrl + "login")) // We could use assert too, dunno which one is clearer

      When("User fills sign in form and submit")
      val appMainPage = homePage.signInWith(username, password)

      Then("User should have access to its content on Stample")
      appMainPage.stampleRootDisplayed
    }

/*    scenario("User sign from his mobile") {

    }*/
  }
}
