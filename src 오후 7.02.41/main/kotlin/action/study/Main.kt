package action.study

val ITEM_MAP = mutableMapOf<String, Item>()
val PAYMENT_CARD = mutableListOf<Order>()
val PAYMENT_CASH = mutableListOf<Order>()

fun main() {
    println("포스기 시작합니다.")
    var flag = true
    while(flag) {
        println("1.메뉴 관리 2.주문 관리 3.결제 관리 4.나가기")
        when(readLine()!!.toInt()) {
            1 -> menuManagement()
            2 -> orderManagement()
            3 -> paymentManagement()
            4 -> {
                flag = false
                println("포스기 종료합니다.")
            }
        }
    }
}

// class로 뺄 수 있을 듯 하다.
fun menuManagement() {
    var menuFlag = true
    while(menuFlag) {
        println("1. 메뉴 생성 2. 메뉴 조회 3. 메뉴 수정 4. 메뉴 삭제 5.나가기")
        when (readLine()!!.toInt()) {
            1 -> {
                println("메뉴 이름, 메뉴 가격, 메뉴 수량을 입력해주세요.")
                val name = readLine().toString()
                val price = readLine()!!.toInt()
                val stockQuantity = readLine()!!.toInt()
                // 객체를 하나만 사용할 수 있도록
                Item().createItem(name, price, stockQuantity)
            }
            2 -> {
                println("메뉴를 조회합니다.")
                Item().getItem()
            }
            3 -> {
                println("수정할 메뉴 이름, 메뉴 가격, 메뉴 수량을 입력해주세요.")
                val name = readLine().toString()
                val price = readLine()!!.toInt()
                val stockQuantity = readLine()!!.toInt()
                Item().updateItem(name, price, stockQuantity)
            }
            4 -> {
                println("삭제할 메뉴 이름을 입력해주세요.")
                val name = readLine().toString()
                Item().deleteItem(name)
            }
            5 -> {
                menuFlag = false
            }
        }
    }
}

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

fun paymentManagement() {
    var paymentFlag = true
    while(paymentFlag) {
        println("1.하루매출 카드결제 내역 조회 2.하루매출 현금결제 내역조회 3.나가기")

        when (readLine()!!.toInt()) {
            1 -> {
                val totalCardPayment = Payment().getCardPayment()
                println("$totalCardPayment 원")
            }
            2 -> {
                val totalCashPayment = Payment().getCashPayment()
                println("$totalCashPayment 원")
            }
            3 -> paymentFlag = false
        }
    }
}