import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}
import testConfig.TestConfig
import testUtils.StampleCreationComponents
import testUtils.testDatas.{SignupData, StampleData}


class TestStampleCreation extends StampleCreationComponents with StampleData with SignupData {
  info("As a User")
  info("I want to be able to create a new Stample")

  feature("Create Stample") {

    scenario("User create a Stample from timeline using new button") {

      Given("User is connected to Stample")
      mainPage.openPage(baseUser.username, baseUser.password)
      newButton.openStampleCreator
      assert(stampleCreator.isOpened)

      When("User fills stample and save it")
      // TODO order of actions matters (especially for upload it seems) i don't understand why right now
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
      navigationBar.openMyLibraries
      timeline.openNthLibrary(0)
      timeline.openNthStample(0)

      And("stample content should be consistent with datas")
      assert(maximisedStample.isReminderSet)
      assert(maximisedStample.title === title)
      assert(maximisedStample.summary === summary) // test doesn't pass with it
      assert(maximisedStample.description === description)
      assert(maximisedStample.getNthCommentContent(0) === comment)
      assert(maximisedStample.descriptionContainsImg)
      assert(maximisedStample.descriptionContainsIframe)
      assert(maximisedStample.getNthTagName(0) === "#" + hashtag1)
      assert(maximisedStample.getNthTagName(1) === "#" + hashtag2)
      assert(filename contains maximisedStample.fileNthAttachedName(0))
    }
  }
}
