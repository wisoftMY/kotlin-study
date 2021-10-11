package action.study

fun posManagement() {
    println("포스기 시작합니다.")
    var flag = true
    while(flag) {
        println("1.메뉴 관리 2.주문 관리 3.결제 관리 4.나가기")
        when(readLine()!!.toInt()) {
            1 -> MenuManagement().menuManagement()
            2 -> OrderManagement().orderManagement()
            3 -> PaymentManagement().paymentManagement()
            4 -> {
                flag = false
                println("포스기 종료합니다.")
            }
        }
    }
}