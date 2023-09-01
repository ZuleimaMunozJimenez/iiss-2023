case class Order(orderId: Int, items: List[String], totalAmount: Double)
case class OrderProcessingResult(orderId: Int, success: Boolean, message: String)
