import org.scalatest.{Matchers, GivenWhenThen, FeatureSpec}
import testUtils.StampleMaximisedComponents

/**
  * Created by dev on 16/12/15.
  */
class TestStampleMaximised extends FeatureSpec with GivenWhenThen with Matchers with StampleMaximisedComponents {
  val username: String = "Username2"
  val password: String = "Password"
  val hashtag1: String = "HASHTAG4"
  val hashtag2: String = "HASHTAG5"
  val hashtag3: String = "HASHTAG6"
  val comment1: String = "Super comment1"
  val comment2: String = "Super comment2"
  val comment3: String = "Super comment3"
  val editComment: String = "Duper"

  info("As a Stample user")
  info("I want to be able to open a Stample in maximised view")
  info("and do some actions on it")

  feature("Stample maximised") {

    scenario("User open and use Stample maximised") {

      Given("User connect to the Stample homepage")
      mainPage.openPage(username, password)
      navigationBar.openMyLibraries
      timeline.openNthLibrary(0)
      timeline.openNthStample(0)
      assert(maximisedStample.isOpened)

      And("stample must contain a picture")
      assert(maximisedStample.descriptionContainsImg)

      And("stample must contain a video")
      assert(maximisedStample.descriptionContainsIframe)

      And("stample must have a reminder set on it")
      assert(maximisedStample.isReminderSet)

      And("stample must have been commented")
      assert(maximisedStample.getNthComment(0) contains "")

      And("stample must have at least one attachment")
      assert(maximisedStample.fileNthAttachedName(0) !== 0)

      And("stample must have at least one hashtag")
      assert(maximisedStample.getNthTagName(0) !== "")


      When("User interact and edit stample")
      maximisedStample.setReminder("inAMonth")
      maximisedStample.setFavorite
      maximisedStample.addHashtag(hashtag1)
      maximisedStample.addHashtag(hashtag2)
      maximisedStample.addHashtag(hashtag3)
      maximisedStample.deleteNthTag(0)
      maximisedStample.likeStample
      maximisedStample.addComment(comment1)
      maximisedStample.editComment(0, editComment)
      maximisedStample.deleteNthComment(0)
      maximisedStample.editStample
      maximisedStample.closeStample


      Then("Stample edited should be consistent with new datas")

    }
  }
}
