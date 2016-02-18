import utils.StamplePages
import datas.{User, UserDataProvider}


class TestLogin extends StamplePages with UserDataProvider {
  def userHasSignedUp(user: User)(action: User => Any) = {
    homePage.openPage
    homePage.signUpWith(user)
    action(user)
  }

  def userHasLoggedOut(user: User)(action: User => Any) = {
    homePage.openPage
    action(user)
  }

  info("As a Stample User")
  info("I want to be able to sign in to Stample")
  info("So i can start using Stample")

  feature("Sign in") {
    userHasSignedUp(User.generateRandomUser) { user =>
      userHasLoggedOut(user) { baseUser =>
        scenario("User sign in from homepage menu") {
          Given("User connect to the Stample homepage")
          homePage.openPage

          When("User fills sign in form and submit")
          homePage.signInWith(baseUser.username, baseUser.password)

          Then("User should have access to its content on Stample")
          assert(mainPage.stampleRootDisplayed)
        }
      }
    }
  }
}
