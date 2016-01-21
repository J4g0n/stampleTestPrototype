package testUtils.testDatas


case class User(
                 email: String,
                 username: String,
                 firstname: String,
                 lastname: String,
                 password: String
               )
object User {
  def generateRandomUser = {
    val userNb = (Math.random() * 1000000).toInt.toString
    new User(
      s"quelquun$userNb@stample.co",
      s"JoDalton$userNb",
      "moins",
      "exunard",
      "password"
    )
  }

  val baseUser = generateRandomUser
}

trait SignupData {
  val baseUser = User.baseUser

  val randomUser = User.generateRandomUser

  val user2 = new User(
    "simon.andreux+140@gmail.com",
    "username2",
    "josé",
    "bové",
    "password"
  )
}
