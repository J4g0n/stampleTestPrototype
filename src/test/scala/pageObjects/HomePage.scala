package pageObjects


trait HomePage extends Page {
  def signInWith(username: String, password: String): AppMainPage

  def signUpWith (email: String, username: String, firstname: String, lastname: String, password: String): AppMainPage
}

