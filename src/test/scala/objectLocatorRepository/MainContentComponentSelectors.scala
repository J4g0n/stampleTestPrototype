package objectLocatorRepository

import objectLocatorRepository.objectMapUtils._


/**
  * Created by dev on 30/11/15.
  */
trait MainContentComponentSelectors extends ObjectMapRepository {
  val MAIN_CONTENT_SPACE: Selector = "mainContent.spaces"
  val MAIN_CONTENT_STAMPLE: Selector = "mainContent.stamples"
  val MAIN_CONTENT_LIBRARY: Selector = "mainContent.libraries"
  val MAIN_CONTENT_STAMPLE_TITLE: Selector = "mainContent.stample.title"
  val MAIN_CONTENT_STAMPLE_SUMMARY: Selector = "mainContent.stample.summary"
  val MAIN_CONTENT_STAMPLE_DESCRIPTION: Selector = "mainContent.stample.description"
  val MAIN_CONTENT_STAMPLE_DESCRIPTION_PICTURE: Selector = "mainContent.stample.description.picture"
  val MAIN_CONTENT_STAMPLE_DESCRIPTION_VIDEO: Selector = "mainContent.stample.description.video"

  val FOLDER_CONTENT_MORE_BUTTON: Selector = "mainContent.moreButton"

  // TODO trying things, we should investigate further to make sure this work everytime properly
  /*def MAIN_CONTENT_NTH_SPACE(n: Int): Selector = {
    MAIN_CONTENT_SPACE_TEMPLATE match {
      case selector: TemplateSelector => selector.formatter(n.toString)
      case _ => throw new Error ("You must provide a template so that an index can be applied to this css")
    }
  }

  def MAIN_CONTENT_NTH_STAMPLE(n: Int): Selector = {
    MAIN_CONTENT_STAMPLE_TEMPLATE match {
      case selector: TemplateSelector => selector.formatter(n.toString)
      case _ => throw new Error ("You must provide a template so that an index can be applied to this css")
    }
  }*/
}
