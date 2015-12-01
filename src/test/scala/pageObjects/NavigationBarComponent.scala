package pageObjects

import objectLocatorRepository.NavigationBarComponentSelectors

/**
  * Created by dev on 30/11/15.
  */
class NavigationBarComponent extends AppMainPage with NavigationBarComponentSelectors {
  def openMyLibraries = click on NAVIGATION_MY_LIBRARIES_BUTTON

  def openMySharedLibraries = click on NAVIGATION_MY_SHARED_LIBRARIES_BUTTON

  def openMyGroups = click on NAVIGATION_MY_GROUPS_BUTTON

  def openMyFavorites = click on NAVIGATION_MY_FAVORITES_BUTTON

  def openRecentAccesses = click on NAVIGATION_MY_RECENT_ACCESSES_BUTTON
}
