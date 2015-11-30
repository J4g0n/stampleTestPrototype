package pageObjects

import objectLocatorRepository.TimelineFirstStampleComponentSelectors
/**
  * Created by dev on 27/11/15.
  */
class TimelineFirstStampleComponent extends AppMainPage with TimelineFirstStampleComponentSelectors {
  def getTitle = find(TIMELINE_FIRST_STAMPLE_TITLE).get.text

  def getSummary = find(TIMELINE_FIRST_STAMPLE_SUMMARY).get.text

  def getDescrition = find(TIMELINE_FIRST_STAMPLE_DESCRIPTION).get.text
}





