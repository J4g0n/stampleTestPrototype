package pageObjects.pageObjectsImpl

import objectLocatorRepository.NavigationBarComponentSelectors
import pageObjects.NavigationBarComponent
import pageObjects.pageObjectsImpl.pageObjectUtils.BaseComponent

/**
  * Created by dev on 30/11/15.
  */
trait NavigationBarComponentImpl {
  val navigationBarComponent: NavigationBarComponent = new DefaultNavigationBarComponentImpl

  class DefaultNavigationBarComponentImpl extends BaseComponent with NavigationBarComponent with NavigationBarComponentSelectors {
    def openMyLibraries = click on NAVIGATION_MY_LIBRARIES_BUTTON

    def openMySharedLibraries = click on NAVIGATION_MY_SHARED_LIBRARIES_BUTTON

    def openMyGroups = click on NAVIGATION_MY_GROUPS_BUTTON

    def openMyFavorites = click on NAVIGATION_MY_FAVORITES_BUTTON

    def openRecentAccesses = click on NAVIGATION_MY_RECENT_ACCESSES_BUTTON
  }
}
