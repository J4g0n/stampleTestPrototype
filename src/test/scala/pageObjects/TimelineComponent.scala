package pageObjects

import objectLocatorRepository.TimelineComponentSelectors

/**
  * Created by dev on 30/11/15.
  */
class TimelineComponent extends AppMainPage with TimelineComponentSelectors {
  def openNthSpace(n: Int) = click on findNthElement(TIMELINE_SPACE, n)

  def openNthStample(n: Int) = click on findNthElement(TIMELINE_STAMPLE, n)

  def openNthLibrary(n: Int) = click on findNthElement(TIMELINE_LIBRARY, n)
}
