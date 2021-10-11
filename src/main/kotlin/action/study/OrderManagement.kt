package action.study

class OrderManagement {

    fun orderManagement() {
        val orderItemList = mutableListOf<OrderItem>()
        var orderFlag = true
        while(orderFlag) {
            println("1.장바구니 담기 2.주문하기 3.나가기")
            when (readLine()!!.toInt()) {
                1 -> {
                    println("장바구니 담기")
                    var orderItemFlag = true
                    Item().getItem()
                    while (orderItemFlag) {
                        println("메뉴 이름과 수량을 입력해주세요. ")
                        val name = readLine().toString()
                        val item = ITEM_MAP.getValue(name)

                        val orderPrice = item.price
                        val count = readLine()!!.toInt()

                        orderItemList.add(OrderItem().createOrderItem(item, orderPrice, count))

                        println("더 담으시려면 1번을 주문을 하고싶으면 2번을 입력해주세요.")
                        val flag = readLine().toString()
                        orderItemFlag = flag == "1"
                    }

                    println("장바구니 메뉴를 나갑니다.")
                }
                2 -> {
                    println("주문을 진행합니다.")
                    val order = Order().createOrder(orderItemList)

                    println("주문 목록")
                    order.getOrderItem()

                    println("---------------------------")
                    println("주문 총 가격")
                    val totalPrice = order.getTotalPrice()
                    println(totalPrice)
                    println("주문 시간")
                    println(order.orderDate)

                    println("결제 방식을 선택해주세요. (1.카드 2.현금)")
                    val paymentMethod = readLine()!!.toInt()

                    if(paymentMethod == 1) {
                        PAYMENT_CARD.add(order)
                        Payment().createPayment(order, PaymentStatus.CARD)
                        println()
                    } else {
                        PAYMENT_CASH.add(order)
                        Payment().createPayment(order, PaymentStatus.CASH)
                    }
                    println("결제가 완료되었습니다.")
                }
                3 -> {
                    orderFlag = false
                }
            }
        }
    }
}