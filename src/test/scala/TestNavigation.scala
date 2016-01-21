import org.scalatest.{FeatureSpec, Matchers, GivenWhenThen}
import testConfig.TestConfig
import testUtils.NavigationComponents
import testUtils.testDatas.UserDataProvider


class TestNavigation extends NavigationComponents with UserDataProvider {
  info("As a Stample User")
  info("I want to be able to navigate into Stample")

  feature("Navigation") {

    scenario("User navigate through his home folder") {

      Given("User is connected to the Stample app")
      mainPage.openPage(baseUser.username, baseUser.password)
      assert(mainPage.stampleRootDisplayed)

      When("User click on home button")
      navigationBar.openMyLibraries
      //timeline.openNthLibrary(0)
      //timeline.openNthSpace(0)

      Then("User should have access to its content on Stample")
      // TODO assert something here that proves that everything went fine
    }

    scenario("User navigate through his home folder and a sub folder") {

      Given("User is connected to the Stample app")
      mainPage.openPage(baseUser.username, baseUser.password)

      When("User click on home button")
      navigationBar.openMyLibraries
      timeline.openNthLibrary(0)

      Then("User should have access to its content on Stample")
      // TODO assert something here that proves that everything went fine
    }
  }
}
