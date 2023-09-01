import scala.concurrent._
import scala.util.{Success, Failure}
import scala.concurrent.duration.Duration

object OrderProcessingApp extends App {
  implicit val ec: ExecutionContext = scala.concurrent.ExecutionContext.global

  val order = Order(1, List("item1", "item2", "item3"), 100.0)

  val inventoryFuture = OrderProcessor.checkInventory(order)
  val paymentFuture = OrderProcessor.processPayment(order)
  val emailFuture = OrderProcessor.sendConfirmationEmail(order)

  val processingResultFuture: Future[Seq[OrderProcessingResult]] = for {
    inventoryResult <- inventoryFuture
    paymentResult <- paymentFuture
    emailResult <- emailFuture
  } yield Seq(inventoryResult, paymentResult, emailResult)

  processingResultFuture.onComplete {
    case Success(results) =>
      println("Order processing completed:")
      results.foreach(result => println(s"Step ${result.orderId}: ${result.message}"))

    case Failure(ex) =>
      println(s"Order processing failed: ${ex.getMessage}")
  }

  // Sleep for a short time to allow asynchronous operations to complete
  Thread.sleep(3000)
}
