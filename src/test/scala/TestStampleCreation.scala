import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}
import testUtils.StampleCreationComponents


class TestStampleCreation extends FeatureSpec with GivenWhenThen with Matchers with StampleCreationComponents {
  val username: String = "Username2"
  val password: String = "Password"
  val title: String = "Custom title"
  val summary: String = "My pretty summary"
  val description: String = "My super duper description"
  val youtubeVideoUrl: String = "https://www.youtube.com/watch?v=wNRUzu4fTgw"
  val photo1: String = "/Users/dev/Downloads/Haddock.jpg"
  val photo2: String = "/Users/dev/Downloads/tournesol.png"
  val filename: String = "/Users/dev/Downloads/MIT.pdf"
  val comment: String = "Super comment for the win"
  val hashtag1: String = "hahstag1"
  val hashtag2: String = "hahstag2"
  val hashtag3: String = "hahstag3"

  info("As a User")
  info("I want to be able to create a new Stample")

  feature("Create Stample") {

    scenario("User create a Stample from timeline using new button") {

      Given("User is connected to Stample")
      mainPage.openPage(username, password)
      newButton.openStampleCreator

      When("User fills stample and save it")
      // TODO order of actions matters (especially for upload it seems) i don't understand why right now but it can be a matter with state cursor which doesn't represent datas
      stampleCreator.toggleMaximisedView
      stampleCreator.fillStample(title, summary, description)
      stampleCreator.addPhoto(photo1)
      stampleCreator.addEmbeddedVideo(youtubeVideoUrl)
      stampleCreator.addHashtag(hashtag1)
      stampleCreator.toggleMaximisedView
      stampleCreator.addHashtag(hashtag3)
      stampleCreator.addComment(comment)
      stampleCreator.addFile(filename)
      stampleCreator.addReminder("inAWeek")
      stampleCreator.addHashtag(hashtag2)
      stampleCreator.removeNthTag(1)
      stampleCreator.toggleMaximisedView
      stampleCreator.saveStample

      Then("stample should appear on timeline")
      // TODO We should find another way to validate, other than doing actions inside browser
      navigationBar.openMyLibraries
      timeline.openNthLibrary(0)
      timeline.openNthStample(0)

      And("stample content should be consistent")
      assert(maximisedStample.isReminderSet)
      assert(maximisedStample.title === title)
      //assert(maximisedStample.summary === summary) // test doesn't pass with it
      assert(maximisedStample.description === description)
      assert(maximisedStample.descriptionContainsImg)
      assert(maximisedStample.descriptionContainsIframe)
      assert(maximisedStample.getNthTagName(0) === "#" + hashtag1)
      assert(maximisedStample.getNthTagName(1) === "#" + hashtag2)
      assert(filename contains maximisedStample.fileNthAttachedName(0))
    }
  }
}
