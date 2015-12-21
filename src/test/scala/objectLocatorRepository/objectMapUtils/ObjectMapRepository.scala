package objectLocatorRepository.objectMapUtils

import java.io.File

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory

import com.github.kxbmap.configs.Configs
import com.github.kxbmap.configs.syntax._
import objectLocatorRepository.objectMapUtils


sealed abstract class Selector(val value: String, selectorType: String)
case class CssSelector(override val value: String) extends Selector(value, "id")
case class IdSelector(override val value: String) extends Selector(value, "css")
case class XPathSelector(override val value: String) extends Selector(value, "xpath")
case class ClassSelector(override val value: String) extends Selector(value, "class")
// TODO investigate a way to build css query from template using some king of build function
//case class TemplateSelector(override val value: String)(val formatter: String => Selector) extends Selector(value, "cssTemplate")

abstract case class Serialiser[T]()

trait MapRepository {

  protected val path: String = ""
  val configManager = {
    val filename = "selectorsMapObject.conf"
    val mapObjectFile = new File(filename)
    ConfigFactory.parseFile(mapObjectFile)
  }

  def mapConfig[T[_]](toMap: Configs[T[String]]): Configs[T[Selector]] = toMap.mapF[T, String, Selector](strToSelector(_))

  def deserialize[T[_], String, Selector] = mapConfig[T](Configs.MapF[T[_], String, Selector]) //MapF[T[Selector], String, Selector] /*{ /*str: String => strToSelector(str)*/}*/ )

  //def deserializeToCaseClass(deserializer: Config => T): T = deserializer(configManager)

  implicit def strToSelector(keyId: String): Selector = {
    ObjectMapRepository.getSelectorFromString(keyId)
  }
}


trait ObjectMapRepository {
  implicit def getLocator(keyId: String): Selector = {
    ObjectMapRepository.objectMap(keyId)
  }
}

object ObjectMapRepository {
  val objectMap = loadObjectMapFromFile

  def getSelectorFromString(selectorString: String): Selector = {
    val splittedSelector = selectorString.split("->")
    val selectorType = splittedSelector.head
    val selectorValue = splittedSelector.last
    selectorType match {
      case "id" => IdSelector(selectorValue)
      case "css" => CssSelector(selectorValue)
      case "xpath" => XPathSelector(selectorValue)
      case "class" => ClassSelector(selectorValue)
      //case "cssTemplate" => TemplateSelector(selectorValue)(index => CssSelector(selectorValue.format(index)))
      case _ => throw new Error(splittedSelector.head + ": this kind of selector doesn't exist")
    }
  }

  private def addToObjectMap(line: String) = {
    val splittedLine = line.split("=")
    val selector: Selector = getSelectorFromString(splittedLine.last)
    splittedLine.head -> selector
  }


  private def loadObjectMapFromFile = {
    import scala.io.Source

    val filename = "selectorsMapObject.conf"
    Source.fromFile(filename)
      .getLines
      // .filter(_.matches("[A-z]*=(css|id|class|xpath)->*"))
      .map(addToObjectMap(_)).toMap
  }
}
