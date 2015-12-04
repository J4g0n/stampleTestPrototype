package pageObjects.pageObjectsImpl

import objectLocatorRepository.TimelineComponentSelectors
import pageObjects.TimelineComponent
import pageObjects.pageObjectsImpl.pageObjectUtils.BaseComponent

/**
  * Created by dev on 30/11/15.
  */
trait TimelineComponentImpl {

  val timelineComponent: TimelineComponent = new DefaultTimelineComponentImpl

  class DefaultTimelineComponentImpl extends BaseComponent with TimelineComponent with TimelineComponentSelectors {
    def openNthSpace(n: Int) = click on findNthElement(TIMELINE_SPACE, n)

    def openNthStample(n: Int) = click on findNthElement(TIMELINE_STAMPLE, n)

    def openNthLibrary(n: Int) = click on findNthElement(TIMELINE_LIBRARY, n)
  }
}
