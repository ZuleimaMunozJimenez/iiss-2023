import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object OrderProcessor {
  def checkInventory(order: Order): Future[OrderProcessingResult] = {
    val result = OrderProcessingResult(order.orderId, itemInventoryAvailable(order.items), "Inventory check passed.")
    Future.successful(result)
  }

  def processPayment(order: Order): Future[OrderProcessingResult] = {
    val result = OrderProcessingResult(order.orderId, isPaymentSuccessful(), "Payment processed successfully.")
    Future.successful(result)
  }

  def sendConfirmationEmail(order: Order): Future[OrderProcessingResult] = {
    val result = OrderProcessingResult(order.orderId, sendEmail(order), "Confirmation email sent.")
    Future.successful(result)
  }

  private def itemInventoryAvailable(items: List[String]): Boolean = {
    // Simulate item availability
    !items.contains("out_of_stock_item")
  }

  private def isPaymentSuccessful(): Boolean = {
    // Simulate payment success
    math.random() < 0.8
  }

  private def sendEmail(order: Order): Boolean = {
    // Simulate email sending
    math.random() < 0.9
  }
}
