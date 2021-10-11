package action.study

class PaymentManagement {

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
}