import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}
import testUtils.StampleCreationComponents


class TestStampleCreation extends FeatureSpec with GivenWhenThen with Matchers with StampleCreationComponents {
  val username: String = "Username2"
  val password: String = "Password"
  val title: String = "<div>Lorem ipsum dolor sit amet<p>Sed quis ex ut orci</p></div>"
  val summary: String = "&\\\"'()àø@#¨€*`£%ù+=:/.;…∞?,çÇ«»¶å{[}]—‘’“”ë„´•ŸÑ~ßb◊©≈‹ ≤<>µ¬ÈÏÌﬁƒ∂Ò‡æÂê®†Úºîœπô"
  val description: String =
    "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed quis ex ut orci venenatis pharetra at ut tellus. Vestibulum at enim ultricies, blandit ipsum ac, rhoncus diam. Cras a orci ac elit cursus pulvinar sit amet ornare elit.</p>" +
    "<p>Sed semper massa vel consequat vehicula. Maecenas in aliquet erat, sed pulvinar felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Suspendisse leo arcu, suscipit in risus pretium, maximus volutpat neque.</p>" +
    "<p>Quisque vel vehicula nibh. Etiam semper nisi in elementum aliquet. Sed efficitur diam at ligula tempus, at molestie dolor suscipit. Nulla aliquam odio ac vulputate congue. In porta congue libero, in viverra eros imperdiet vitae.</p>" +
    "<p>Vivamus condimentum vel leo vel pretium. Fusce interdum nibh augue, et congue nunc porttitor in. Donec eu ligula in ligula euismod commodo sed sed nisi. Nulla facilisi.</p>" +
    "<p>Suspendisse potenti. Proin ornare justo sed nulla lobortis, non sodales libero accumsan. Sed commodo justo ut porta maximus. Sed vitae augue nec erat tempor posuere elementum quis mauris.</p>" +
    "<p>Aenean faucibus tincidunt quam, fringilla gravida dui fringilla in. Cras porta augue vitae tortor tristique consectetur. Phasellus malesuada congue aliquet. Phasellus sodales sodales eros, ut lacinia lacus lobortis sit amet. Nulla blandit libero sit amet mi dictum efficitur.</p> "
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
      assert(stampleCreator.isOpened)

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

      And("stample content should be consistent with datas")
      assert(maximisedStample.isReminderSet)
      assert(maximisedStample.title === title)
      assert(maximisedStample.summary === summary) // test doesn't pass with it
      assert(maximisedStample.description === description)
      assert(maximisedStample.getNthComment(0) === comment)
      assert(maximisedStample.descriptionContainsImg)
      assert(maximisedStample.descriptionContainsIframe)
      assert(maximisedStample.getNthTagName(0) === "#" + hashtag1)
      assert(maximisedStample.getNthTagName(1) === "#" + hashtag2)
      assert(filename contains maximisedStample.fileNthAttachedName(0))
    }
  }
}
