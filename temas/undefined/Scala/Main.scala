// Archivo: Main.scala

import java.util.Scanner

object Main {
  def main(args: Array[String]): Unit = {
    val authResult1 = Authentication.authenticateUser("alice", "secret")
    val authResult2 = Authentication.authenticateUser("bob", "password")

    authResult1 match {
      case Right(user) =>
        println("Authentication successful:")
        User.printUserInfo(user)
      case Left(errorMessage) =>
        println(s"Authentication failed: $errorMessage")
    }

    authResult2 match {
      case Right(user) =>
        println("Authentication successful:")
        User.printUserInfo(user)
      case Left(errorMessage) =>
        println(s"Authentication failed: $errorMessage")
    }
  }
}
