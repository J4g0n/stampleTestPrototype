package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{ObjectMapRepository, Selector}

/**
  * Created by dev on 30/11/15.
  */
trait NavigationBarComponentSelectors extends ObjectMapRepository {
  val NAVIGATION_MY_PROFILE_CONTENT: Selector = "navigation.myProfileContent"
  val NAVIGATION_MY_LIBRARIES_BUTTON: Selector = "navigation.myLibraries"
  val NAVIGATION_MY_SHARED_LIBRARIES_BUTTON: Selector = "navigation.mySharedLibraries"
  val NAVIGATION_MY_GROUPS_BUTTON: Selector = "navigation.myGroups"
  val NAVIGATION_MY_FAVORITES_BUTTON: Selector = "navigation.myFavorites"
  val NAVIGATION_MY_RECENT_ACCESSES_BUTTON: Selector = "navigation.myRecentAccesses"
}
