package datas


case class User(
                 email: String,
                 username: String,
                 firstname: String,
                 lastname: String,
                 password: String
               )
object User {
  def generateRandomUser = {
    val userNb = (Math.random() * 10000000).toInt.toString
    new User(
      s"quelquun$userNb@stample.co",
      s"JoDalton$userNb",
      "moins",
      "exunard",
      "password"
    )
  }

  val baseUser = new User(
    "jodalton@stample.co",
    "jodalton",
    "Jo",
    "Dalton",
    "batterie"
  )
}

trait UserDataProvider {
  val baseUser = User.baseUser

  val testUser = new User(
    "jodalton@stample.co",
    "jodalton",
    "Jo",
    "Dalton",
    "batterie"
  )

  def genRandomUser = User.generateRandomUser
}
