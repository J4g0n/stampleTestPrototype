import utils.StampleCreationComponents
import utils.Reader._
import datas.{User, UserDataProvider, StampleDataProvider}


class TestStampleCreation extends StampleCreationComponents with StampleDataProvider with UserDataProvider {

  def userHasSignedUp: User => Unit = user => {
    homePage.openPage
    homePage.signUpWith(user)
  }

  def userHasNavigatedToFirstLibrary: User => Unit = user => {
    navigationBar.openMyLibraries
    mainContent.openNthLibrary(0)
  }

  def userOpenedNewButtonMenu: User => Unit = user => {
    mainContent.openNewMenu
    newButton.openStampleCreator
  }

  def preTest = for {
    _ <- userHasSignedUp
    _ <- userHasNavigatedToFirstLibrary
    _ <- userOpenedNewButtonMenu
  } yield Unit

  def postTest: User => Unit = user => Unit

  def buildTest(test: User => Unit) = for {
    _ <- preTest
    _ <- test
    _ <- postTest
  } yield Unit

  def run(user: User)(test: User => Unit) = buildTest(test).read(user)

  info("As a User")
  info("I want to be able to create a new Stample")

  feature("Create Stample") {
    run(User.generateRandomUser) { user =>
      scenario("User create a Stample from timeline using new button") {

        Given("User is connected to Stample")
        assert(stampleCreator.isOpened)

        When("User fills stample and save it")
        // TODO order of actions matters (especially for upload it seems) i don't understand why right now
        stampleCreator.fillStample(baseStample.title, baseStample.summary, baseStample.description)
        stampleCreator.addPhoto(baseStample.photoUrls(0))
        stampleCreator.addEmbeddedVideo(baseStample.embeddedVideosUrls(0))
        stampleCreator.addHashtag(baseStample.hashtags(0))
        stampleCreator.addHashtag(baseStample.hashtags(2))
        stampleCreator.addComment(baseStample.comments(0))
        stampleCreator.addFile(baseStample.attachments(0))
        //stampleCreator.addReminder("inAWeek") // disabled right now until we fix tests completely
        stampleCreator.addHashtag(baseStample.hashtags(1))
        //stampleCreator.removeNthTag(1) // disabled too since it seems that it's impossible to remove hashtags in new version
        stampleCreator.saveStample

        Then("stample should appear on timeline")
        navigationBar.openMyLibraries
        mainContent.openNthLibrary(0)
        mainContent.openNthStample(0)

        And("stample content should be consistent with datas")
        //assert(maximisedStample.isReminderSet)
        assert(maximisedStample.title === baseStample.title)
        assert(maximisedStample.summary === baseStample.summary) // test doesn't pass with it
        assert(maximisedStample.description === baseStample.description)
        assert(maximisedStample.getNthCommentContent(0) === baseStample.comments(0))
        assert(maximisedStample.descriptionContainsImg)
        assert(maximisedStample.descriptionContainsIframe)
        assert(maximisedStample.getNthTagName(0) === "#" + baseStample.hashtags(0))
        assert(maximisedStample.getNthTagName(1) === "#" + baseStample.hashtags(2))
        assert(maximisedStample.getNthTagName(2) === "#" + baseStample.hashtags(1))
        assert(baseStample.attachments(0) contains maximisedStample.fileNthAttachedName(0))
      }
    }
  }
}
