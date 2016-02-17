import testUtils.NavigationComponents
import testDatas.{User, UserDataProvider}


class TestNavigation extends NavigationComponents with UserDataProvider {
  def userHasSignedUp(user: User)(action: User => Any) = {
    homePage.openPage
    homePage.signUpWith(genRandomUser)
    action(user)
  }

  info("As a Stample User")
  info("I want to be able to navigate into Stample")

  feature("Navigation") {

    scenario("User navigate through his home folder") {
      userHasSignedUp(User.generateRandomUser) { user =>
          Given("User is connected to the Stample app")
          assert(mainPage.stampleRootDisplayed)

          When("User click on home button")
          navigationBar.openMyLibraries
          //timeline.openNthLibrary(0)
          //timeline.openNthSpace(0)

          Then("User should have access to its content on Stample")
          // TODO assert something here that proves that everything went fine
        }
      }
    }

    scenario("User navigate through his home folder and a sub folder") {
      userHasSignedUp(User.generateRandomUser) { user =>
        Given("User is connected to the Stample app")
        assert(mainPage.stampleRootDisplayed)

        When("User click on home button")
        navigationBar.openMyLibraries
        timeline.openNthLibrary(0)

        Then("User should have access to its content on Stample")
        // TODO assert something here that proves that everything went fine
      }
    }
}
