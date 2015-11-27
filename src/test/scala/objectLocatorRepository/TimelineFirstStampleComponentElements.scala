package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.ObjectMapRepository

/**
  * Created by dev on 27/11/15.
  */
trait TimelineFirstStampleComponentElements extends ObjectMapRepository {
  val TIMELINE_FIRST_STAMPLE_TITLE: Selector = "timeline.firstStample.title"
  val TIMELINE_FIRST_STAMPLE_SUMMARY: Selector = "timeline.firstStample.summary"
  val TIMELINE_FIRST_STAMPLE_DESCRIPTION: Selector = "timeline.firstStample.description"
}
