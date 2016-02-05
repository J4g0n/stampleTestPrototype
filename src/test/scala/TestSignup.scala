import testUtils.OnBoardingComponents
import testDatas.UserDataProvider


class TestSignup extends OnBoardingComponents with UserDataProvider {
  info("As a Visitor")
  info("I want to be able to sign up to Stample")
  info("So i can start using Stample")
  info("On desktop and mobile devices as well")

  feature("Sign up") {

    scenario("User sign up from homepage") {
      Given("User connect to the Stample homepage")
      homePage.openPage

      When("User fills sign in form and submit")
      homePage.signUpWith(genRandomUser)

      Then("User should have access to its content on Stample")
      mainPage.stampleRootDisplayed

      And("OnBoarding is displayed")
      assert(onBoarding.isOpen)
    }

    scenario("User sign up and close onBoarding") {
      Given("User connect to the Stample homepage")
      homePage.openPage

      When("User fills sign in form and submit")
      homePage.signUpWith(baseUser)
      onBoarding.closeOnBoarding

      Then("User should have access to its content on Stample")
      mainPage.stampleRootDisplayed

      And("OnBoarding isn't displayed")
      assert(!onBoarding.isOpen)
    }
  }
}
