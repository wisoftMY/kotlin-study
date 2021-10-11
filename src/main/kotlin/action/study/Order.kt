package action.study

import java.time.LocalDateTime

class Order() {
    private val orderItems: MutableList<OrderItem> = mutableListOf()
    lateinit var orderDate: LocalDateTime

    fun createOrder(orderItems: List<OrderItem>): Order {
        val order = Order()
        for (orderItem in orderItems) {
            order.addOrderItem(orderItem)
        }
        order.orderDate = LocalDateTime.now()
        return order
    }

    fun cancel() {
        for(orderItem in this.orderItems) {
            orderItem.cancel()
        }
    }

    fun getOrderItem() {
        for(orderItem in this.orderItems) {
            println("------------------------------")
            println("주문 메뉴: ${orderItem.item.name}")
            println("주문 가격: ${orderItem.getTotalPrice()}")
        }
    }

    private fun addOrderItem(orderItem: OrderItem) {
        orderItems.add(orderItem)
    }

    fun getTotalPrice(): Int {
        var totalPrice = 0
        for (orderItem in orderItems) {
            totalPrice += orderItem.getTotalPrice()
        }
        return totalPrice
    }
}