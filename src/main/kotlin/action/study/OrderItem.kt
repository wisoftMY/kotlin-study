package action.study

class OrderItem() {

    lateinit var item: Item
    var orderPrice: Int = 0
    var count: Int = 0

    fun createOrderItem(item: Item, orderPrice :Int, count :Int) : OrderItem {
        val orderItem = OrderItem()
        orderItem.item = item
        orderItem.orderPrice = orderPrice
        orderItem.count = count

        item.removeStock(count)
        return orderItem
    }

    fun cancel() {
        item.addStock(this.count)
    }

    fun getTotalPrice(): Int {
        return this.orderPrice * this.count
    }
}