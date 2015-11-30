package objectLocatorRepository.objectMapUtils


case class Selector(keyId: String, selectorType: String)

object ObjectMap {
  val objectMap = Map(
    ("homepage.login", Selector("li.main-nav.cd-signin a", "css")),
    ("homepage.signup", Selector("li.main-nav.cd-signup a", "css")),

    ("signin.email", Selector("signin-email", "id")),
    ("signin.password", Selector("signin-password", "id")),

    ("signup.email", Selector("signup-email", "id")),
    ("signup.username", Selector("signup-username", "id")),
    ("signup.firstname", Selector("signup-firstname", "id")),
    ("signup.lastname", Selector("signup-lastname", "id")),
    ("signup.password", Selector("signup-password", "id")),
    ("signup.acceptTerms", Selector("accept-terms", "id")),

    ("new.button", Selector("#new-button .new-button-icon", "css")),
    ("new.stample", Selector("#new-button .new-stample", "css")),

    ("stampleCreator.title", Selector(".stample-creation .stample-creation-title input", "css")),
    ("stampleCreator.summary", Selector(".stample-creation .stample-creation-summary input", "css")),
    ("stampleCreator.description", Selector(".stample-creation .stample-creation-description", "css")),
    ("stampleCreator.saveButton", Selector(".stample-creation-tool-bar .save-and-quit", "css")),
    ("stampleCreator.reminderButton", Selector(".stample-creation-tool-bar .reminder", "css")),

    ("timeline.firstStample.title", Selector("#stamples span:nth-child(1) .title", "css")), // Sloppy selector but i don't want to introduce dependencies between selectors at least for now :/
    ("timeline.firstStample.summary", Selector("#stamples span:nth-child(1) .summary", "css")),
    ("timeline.firstStample.description", Selector("#stamples span:nth-child(1) .description", "css"))
  )
}

// TODO I would like to remove dependency need to WebBrowser but don't know how yet, maybe with a trait that is using WebBrowser as a proxy
trait ObjectMapRepository {
  private val objectMap = ObjectMap.objectMap

  def loadObjectMapFromFile = ??? // TODO implement a way to load map object resources from a file

  implicit def getLocator(keyId: String): Selector = {
      objectMap.get(keyId).get
  }
}
