// Archivo: User.scala
case class User(username: String, email: Option[String])

object User {
  def printUserInfo(user: User): Unit = {
    println(s"Username: ${user.username}")
    user.email match {
      case Some(email) => println(s"Email: $email")
      case None => println("Email: Not provided")
    }
  }
}
