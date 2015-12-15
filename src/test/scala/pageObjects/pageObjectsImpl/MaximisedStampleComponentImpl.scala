package pageObjects.pageObjectsImpl

import objectLocatorRepository.MaximisedStampleComponentSelectors
import pageObjects.MaximisedStampleComponent
import pageObjects.pageObjectsImpl.pageObjectUtils.BaseComponent

/**
  * Created by dev on 15/12/15.
  */
trait MaximisedStampleComponentImpl {

  val maximisedStampleComponent: MaximisedStampleComponent = new DefaultMaximisedStampleComponentImpl

  class DefaultMaximisedStampleComponentImpl extends BaseComponent with MaximisedStampleComponent with MaximisedStampleComponentSelectors {
    def title: String = tryFind(MAXIMISED_STAMPLE_TITLE).text

    def summary: String = tryFind(MAXIMISED_STAMPLE_SUMMARY).text

    def description: String = tryFind(MAXIMISED_STAMPLE_DESCRIPTION).text

    private def descriptionContains(words: String): Boolean = description contains words

    def descriptionContainsImg: Boolean = exists(MAXIMISED_STAMPLE_DESCRIPTION_PICTURE)

    def descriptionContainsIframe: Boolean = exists(MAXIMISED_STAMPLE_DESCRIPTION_VIDEO)
  }
}
