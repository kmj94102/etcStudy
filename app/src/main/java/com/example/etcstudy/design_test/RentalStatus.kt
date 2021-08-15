package com.example.etcstudy.design_test

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
