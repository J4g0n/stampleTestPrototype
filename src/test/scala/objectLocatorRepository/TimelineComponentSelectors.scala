package objectLocatorRepository

import objectLocatorRepository.objectMapUtils._


/**
  * Created by dev on 30/11/15.
  */
trait TimelineComponentSelectors extends ObjectMapRepository {
  val TIMELINE_SPACE: Selector = "timeline.spaces"
  val TIMELINE_STAMPLE: Selector = "timeline.stamples"
  val TIMELINE_LIBRARY: Selector = "timeline.libraries"

  // TODO trying things, we should investigate further to make sure this work everytime properly
  /*def TIMELINE_NTH_SPACE(n: Int): Selector = {
    TIMELINE_SPACE_TEMPLATE match {
      case selector: TemplateSelector => selector.formatter(n.toString)
      case _ => throw new Error ("You must provide a template so that an index can be applied to this css")
    }
  }

  def TIMELINE_NTH_STAMPLE(n: Int): Selector = {
    TIMELINE_STAMPLE_TEMPLATE match {
      case selector: TemplateSelector => selector.formatter(n.toString)
      case _ => throw new Error ("You must provide a template so that an index can be applied to this css")
    }
  }*/
}
