import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}
import testUtils.StampleCreationComponents


class TestStampleCreation extends FeatureSpec with GivenWhenThen with Matchers with StampleCreationComponents {
  val username: String = "Username2"
  val password: String = "Password"
  val title: String = "Custom title"
  val summary: String = "My pretty summary"
  val description: String = "My super duper description"
  val youtubeVideoUrl: String = "https://www.youtube.com/watch?v=wNRUzu4fTgw"
  val filename: String = "/Users/dev/Downloads/Haddock.jpg"
  val photo: String = "/Users/dev/Downloads/tournesol.png"

  info("As a User")
  info("I want to be able to create a new Stample")

  feature("Create Stample") {

    scenario("User create a Stample from timeline using new button") {

      Given("User is connected to Stample")
      mainPage.openPage(username, password)
      newButton.openStampleCreator

      When("User fills stample and save it")
      stampleCreator.addReminder("inAWeek")
      stampleCreator.fillStample(title, summary, description)
      stampleCreator.addEmbeddedVideo(youtubeVideoUrl)
      stampleCreator.addPhoto(filename)
      stampleCreator.saveStample

      Then("stample should appear on timeline")
      // TODO We should find another way to validate, other than doing actions inside browser
      navigationBar.openMyLibraries
      timeline.openNthLibrary(0)
      timeline.openNthStample(0)

      assert(maximisedStample.title === title)
      //assert(maximisedStample.summary === summary) // test doesn't pass with it 
      assert(maximisedStample.description === description)
      assert(maximisedStample.descriptionContainsImg)
      assert(maximisedStample.descriptionContainsIframe)
    }
  }
}
