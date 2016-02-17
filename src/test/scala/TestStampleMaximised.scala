import testUtils.StampleMaximisedComponents
import testDatas.{User, UserDataProvider, StampleDataProvider}

/**
  * Created by dev on 16/12/15.
  */
class TestStampleMaximised extends StampleMaximisedComponents with StampleDataProvider with UserDataProvider {
  def userHasSignedUp(user: User)(action: User => Any) = {
    homePage.openPage
    homePage.signUpWith(user)
    action(user)
  }

  def userHasLoggedOut(user: User)(action: User => Any) = {
    homePage.openPage
    action(user)
  }

  info("As a Stample user")
  info("I want to be able to open a Stample in maximised view")
  info("and do some actions on it")

  feature("Stample maximised") {
    userHasSignedUp(User.generateRandomUser) { user =>
      userHasLoggedOut(user) { baseUser =>
        scenario("User open and use Stample maximised") {

          Given("User connect to the Stample homepage")
          mainPage.openPage(baseUser.username, baseUser.password)
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
          assert(maximisedStample.getNthCommentContent(0) contains "")

          And("stample must have at least one attachment")
          assert(maximisedStample.fileNthAttachedName(0) !== "")

          And("stample must have at least one hashtag")
          assert(maximisedStample.getNthTagName(0) !== "")


          When("User interact and edit stample")
          maximisedStample.setReminder("inAMonth")
          maximisedStample.setFavorite
          maximisedStample.addHashtag(baseStample.hashtags(3))
          maximisedStample.addHashtag(baseStample.hashtags(4))
          maximisedStample.addHashtag(baseStample.hashtags(5))
          maximisedStample.deleteNthTag(0)
          maximisedStample.likeStample
          maximisedStample.addComment(baseStample.comments(1))
          maximisedStample.editComment(0, " edited comment")
          maximisedStample.deleteNthComment(0)
          maximisedStample.editStample
          maximisedStample.closeStample


          Then("Stample edited should be consistent with new datas")

        }
      }
    }
  }
}
