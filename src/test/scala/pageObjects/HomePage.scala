package pageObjects

import testDatas.User


trait HomePage extends Page {
  def signInWith(username: String, password: String): Unit

  def signUpWith (email: String, username: String, firstname: String, lastname: String, password: String): Unit

  def signUpWith (user: User): Unit = signUpWith(user.email, user.username, user.firstname, user.lastname, user.password)
}

