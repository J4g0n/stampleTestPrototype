package pageObjects


trait AppMainPage extends Page {
  def openPage(username: String, password: String): Unit

  def stampleRootDisplayed : Boolean
}

