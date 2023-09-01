// Archivo: Authentication.scala
object Authentication {
  def authenticateUser(username: String, password: String): Either[String, User] = {
    // Simulación de autenticación exitosa
    if (username == "alice" && password == "secret") {
      val user = User("alice", Some("alice@example.com"))
      Right(user)
    } else {
      // Autenticación fallida, devolver un mensaje de error
      Left("Authentication failed: Invalid username or password")
    }
  }
}
