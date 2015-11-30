package objectLocatorRepository.objectMapUtils


sealed abstract class Selector(selectorType: String)
case class CssSelector(key: String) extends Selector("id")
case class IdSelector(key: String) extends Selector("css")
case class XPathSelector(key: String) extends Selector("xpath")
case class ClassSelector(key: String) extends Selector("class")


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


  private def loadObjectMapFromFile = {
    import scala.io.Source

    val filename = "selectorsMapObject"
    Source.fromFile(filename).getLines/*.filter(_.matches("[A-z]*=(css|id|class|xpath)->*"))*/.map(addToObjectMap(_)).toMap
  }
}
