package com.example.etcstudy.design_test

open class RentalStatusType(val type : Int){
    companion object {
        const val TYPE_TITLE = 1
        const val TYPE_DETAIL = 2
    }
}

class RentalStatusTitle(type : Int = TYPE_TITLE) : RentalStatusType(type){
    var buildingName : String = ""
    var buildingIdx : Int = 0
    var isOpened : Boolean = false
}

class RentalStatusDetail(type : Int = TYPE_DETAIL) : RentalStatusType(type){
    var ho : String = ""
    var tenantName : String = ""
    var startMonth : String = ""
    var startMonthStatus : Rental = Rental(PaymentStatus.FULL_PAYMENT)
    var middleMonth : String = ""
    var middleMonthStatus: Rental = Rental(PaymentStatus.FULL_PAYMENT)
    var endMonth : String = ""
    var endMonthStatus : Rental = Rental(PaymentStatus.FULL_PAYMENT)
}

data class RentalStatusResult(
    val ho : String,
    val tenantName : String,
    val startMonth : String,
    val startMonthStatus : Rental,
    val middleMonth : String,
    val middleMonthStatus: Rental,
    val endMonth : String,
    val endMonthStatus : Rental
)

data class Rental(
    val status : PaymentStatus
)

enum class PaymentStatus{
    FULL_PAYMENT, NON_PAYMENT, PAYMENT_DUE
}
