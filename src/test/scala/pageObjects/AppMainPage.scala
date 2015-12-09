package pageObjects


trait AppMainPage extends Page {
  def openPage(username: String, password: String): AppMainPage

  def stampleRootDisplayed : Boolean
}

