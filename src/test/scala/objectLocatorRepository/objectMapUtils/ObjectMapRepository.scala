package objectLocatorRepository.objectMapUtils


sealed abstract class Selector(selectorType: String)
case class CssSelector(key: String) extends Selector("id")
case class IdSelector(key: String) extends Selector("css")
case class XPathSelector(key: String) extends Selector("xpath")
case class ClassSelector(key: String) extends Selector("class")

/*
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
}*/

trait ObjectMapRepository {
  implicit def getLocator(keyId: String): Selector = {
    ObjectMapRepository.objectMap(keyId)
  }
}
object ObjectMapRepository {
  val objectMap = loadObjectMapFromFile

  private def getSelectorFromString(selectorString: String): Selector = {
    val splittedSelector = selectorString.split("->")
    println("\t" + splittedSelector.head + " => " + splittedSelector.last)
    val selectorType = splittedSelector.head
    val selectorValue = splittedSelector.last
    selectorType match {
      case "id" => IdSelector(selectorValue)
      case "css" => CssSelector(selectorValue)
      case "xpath" => XPathSelector(selectorValue)
      case "class" => ClassSelector(selectorValue)
      case _ => throw new Error(splittedSelector.head + ": this kind of selector doesn't exist")
    }
  }

  private def addToObjectMap(line: String) = {
    val splittedLine = line.split("=")
    println(splittedLine.head + " ::: " + splittedLine.last)
    val selector: Selector = getSelectorFromString(splittedLine.last)
    splittedLine.head -> selector
  }


  def loadObjectMapFromFile = {
    import scala.io.Source

    val filename = "selectorsMapObject"
    Source.fromFile(filename).getLines.map{addToObjectMap(_)}.toMap
  }
}
