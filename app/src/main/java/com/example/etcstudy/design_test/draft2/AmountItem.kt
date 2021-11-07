package com.example.etcstudy.design_test.draft2

data class AmountItem(
    val tenantName : String?,
    val buildingName : String?,
    val area : String?,
    val ho : String?,
    val contractPeriod : String?,   // 계약 기간
    val yield : String?,            // 수익률
    val deposit : String?,          // 보증금
    val monthly : String?,          // 임대료
    val rentPaid : String           // 지불할 임대료
)
