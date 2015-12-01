import org.scalatest.{FeatureSpec, Matchers, GivenWhenThen}
import pageObjects.HomePage
import testConfig.TestConfig


class TestNavigation extends FeatureSpec with GivenWhenThen with Matchers {

  val username: String = "Username"
  val password: String = "Password"
  val baseUrl: String = TestConfig.baseUrl

  info("As a Stample User")
  info("I want to be able to navigate into Stample")

  feature("Navigation") {

    scenario("User navigate through his home folder") {

      Given("User is connected to the Stample app")
      val homePage = new HomePage
      homePage.openPage
      val appMainPage = homePage.signInWith(username, password)
      val navigationComponent = appMainPage.getNavigation
      val timelineComponent = appMainPage.getTimeline

      When("User click on home button")
      navigationComponent.openMyLibraries
      timelineComponent.openNthLibrary(0)
      timelineComponent.openNthSpace(2)

      Then("User should have access to its content on Stample")
      // TODO assert something here that proves that everything went fine
    }

    scenario("User navigate through his home folder and a sub folder") {

      Given("User is connected to the Stample app")
      val homePage = new HomePage
      homePage.openPage
      val appMainPage = homePage.signInWith(username, password)
      val navigationComponent = appMainPage.getNavigation
      val timelineComponent = appMainPage.getTimeline

      When("User click on home button")
      navigationComponent.openMyLibraries
      timelineComponent.openNthLibrary(0)
      timelineComponent.openNthStample(2)

      Then("User should have access to its content on Stample")
      // TODO assert something here that proves that everything went fine
    }
  }
}
