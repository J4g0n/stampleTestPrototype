import org.scalatest.{FeatureSpec, Matchers, GivenWhenThen}
import testConfig.TestConfig
import testUtils.BaseTest


class TestNavigation extends FeatureSpec with GivenWhenThen with Matchers with BaseTest {

  val username: String = "Username2"
  val password: String = "Password"
  val baseUrl: String = TestConfig.baseUrl

  info("As a Stample User")
  info("I want to be able to navigate into Stample")

  feature("Navigation") {

    scenario("User navigate through his home folder") {

      Given("User is connected to the Stample app")
      mainPage.openPage(username, password)

      When("User click on home button")
      navigationBar.openMyLibraries
      //timeline.openNthLibrary(0)
      //timeline.openNthSpace(0)

      Then("User should have access to its content on Stample")
      // TODO assert something here that proves that everything went fine
    }

    scenario("User navigate through his home folder and a sub folder") {

      Given("User is connected to the Stample app")
      mainPage.openPage(username, password)

      When("User click on home button")
      navigationBar.openMyLibraries
      //timeline.openNthLibrary(0)
      //timeline.openNthStample(0)

      Then("User should have access to its content on Stample")
      // TODO assert something here that proves that everything went fine
    }
  }
}
