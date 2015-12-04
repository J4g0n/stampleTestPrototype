package pageObjects


trait AppMainPage extends Page {
  def openPage(username: String, password: String): AppMainPage

  def stampleRootDisplayed : Boolean

  def getNewButton: NewButtonComponent

  def getStampleEditor: StampleCreatorComponent

  def getNavigation: NavigationBarComponent

  def getTimeline: TimelineComponent
}
