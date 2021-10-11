package action.study

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Payment {

    lateinit var order: Order
    lateinit var paymentStatus: PaymentStatus

    fun createPayment(order: Order, paymentStatus: PaymentStatus): Payment {
        val payment = Payment()
        payment.order = order
        payment.paymentStatus = paymentStatus

        return payment
    }

    fun getCashPayment(): Int {
        var totalCash = 0
        val currentDate: LocalDate = LocalDate.now()
        val formatter = DateTimeFormatter.ISO_DATE

        for(cash in PAYMENT_CASH) {
            val formatted = cash.orderDate.format(formatter)
            if(formatted.toString() == currentDate.toString()) {
                totalCash += cash.getTotalPrice()
            }
        }
        return totalCash
    }

    fun getCardPayment(): Int {
        var totalCard = 0
        val currentDate: LocalDate = LocalDate.now()
        val formatter = DateTimeFormatter.ISO_DATE

        for(cash in PAYMENT_CARD) {
            val formatted = cash.orderDate.format(formatter)
            if(formatted.toString() == currentDate.toString() ) {
                totalCard += cash.getTotalPrice()
            }
        }
        return totalCard
    }
}