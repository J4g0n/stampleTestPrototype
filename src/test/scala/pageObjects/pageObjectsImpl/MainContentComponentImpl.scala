package pageObjects.pageObjectsImpl

import objectLocatorRepository.MainContentComponentSelectors
import pageObjects.MainContentComponent
import pageObjects.pageObjectsImpl.pageObjectUtils.BaseComponent

/**
  * Created by dev on 30/11/15.
  */
trait MainContentComponentImpl {

  val mainContent: MainContentComponent = new DefaultMainContentComponentImpl

  class DefaultMainContentComponentImpl extends BaseComponent with MainContentComponent with MainContentComponentSelectors {
    def openNthSpace(n: Int) = click on findNthElement(MAIN_CONTENT_SPACE, n)

    def openNthStample(n: Int) = click on findNthElement(MAIN_CONTENT_STAMPLE_TITLE, n)

    def openNthLibrary(n: Int) = click on findNthElement(MAIN_CONTENT_LIBRARY, n)

    def openNewMenu: Unit = click on FOLDER_CONTENT_MORE_BUTTON
  }
}
