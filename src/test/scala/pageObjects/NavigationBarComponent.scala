package pageObjects

/**
  * Created by dev on 30/11/15.
  */
trait NavigationBarComponent {
  def openMyLibraries: Unit

  def openMySharedLibraries: Unit

  def openMyGroups: Unit

  def openMyFavorites: Unit

  def openRecentAccesses: Unit

  def isProfileContentDisplayed: Boolean
}
