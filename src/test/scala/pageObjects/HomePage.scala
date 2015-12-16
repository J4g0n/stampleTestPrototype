package pageObjects


trait HomePage extends Page {
  def signInWith(username: String, password: String): Unit

  def signUpWith (email: String, username: String, firstname: String, lastname: String, password: String): Unit
}

