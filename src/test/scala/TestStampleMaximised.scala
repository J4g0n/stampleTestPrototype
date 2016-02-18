import utils.StampleMaximisedComponents
import datas.{User, UserDataProvider, StampleDataProvider}

/**
  * Created by dev on 16/12/15.
  */
class TestStampleMaximised extends StampleMaximisedComponents with StampleDataProvider with UserDataProvider {

  def userHasOpenedAStample(user: User)(action: User => Any) = {
    mainPage.openPage(user.username, user.password)
    navigationBar.openMyLibraries
    mainContent.openNthLibrary(0)
    mainContent.openNthStample(0)
    action(user)
  }

  info("As a Stample user")
  info("I want to be able to open a Stample in maximised view")
  info("and do some actions on it")

  feature("Stample maximised") {
    userHasOpenedAStample(User.baseUser) { user =>
      scenario("User open and use Stample maximised") {

        Given("User connect to the Stample homepage")
        assert(maximisedStample.isOpened)

        And("stample must contain a picture")
        assert(maximisedStample.descriptionContainsImg)

        And("stample must contain a video")
        assert(maximisedStample.descriptionContainsIframe)

        And("stample must have a reminder set on it")
        //assert(maximisedStample.isReminderSet)

        And("stample must have been commented")
        assert(maximisedStample.getNthCommentContent(0) contains "")

        And("stample must have at least one attachment")
        assert(maximisedStample.fileNthAttachedName(0) !== "")

        And("stample must have at least one hashtag")
        assert(maximisedStample.getNthTagName(0) !== "")


        When("User interact and edit stample")
        //maximisedStample.setReminder("inAMonth")
        maximisedStample.setFavorite
        maximisedStample.addComment(baseStample.comments(1))
        maximisedStample.addHashtag(baseStample.hashtags(3))
        maximisedStample.addHashtag(baseStample.hashtags(4))
        maximisedStample.editComment(0, " edited comment")
        maximisedStample.addHashtag(baseStample.hashtags(5))
        //maximisedStample.deleteNthTag(0)
        maximisedStample.likeStample
        maximisedStample.deleteNthComment(0)
        maximisedStample.editStample
        maximisedStample.closeStample


        Then("Stample edited should be consistent with new datas")
        Thread.sleep(1000)
        navigationBar.openMyLibraries
        Thread.sleep(1000)
        mainContent.openNthLibrary(0)
        Thread.sleep(1000)
        mainContent.openNthStample(0)

        And("stample content should be consistent with datas")
        //assert(maximisedStample.isReminderSet)
        assert(maximisedStample.title === baseStample.title)
        assert(maximisedStample.summary === baseStample.summary) // test doesn't pass with it
        assert(maximisedStample.description === baseStample.description)
        assert(maximisedStample.getNthCommentContent(0) contains "Super comment")
        assert(maximisedStample.descriptionContainsImg)
        assert(maximisedStample.descriptionContainsIframe)
        assert(maximisedStample.getNthTagName(0) !== "")
        assert(maximisedStample.getNthTagName(1) !== "")
        assert(maximisedStample.getNthTagName(2) !== "")
        assert(baseStample.attachments(0) contains maximisedStample.fileNthAttachedName(0))
      }
    }
  }
}
