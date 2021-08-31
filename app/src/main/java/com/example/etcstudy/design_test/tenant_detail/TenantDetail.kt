package com.example.etcstudy.design_test.tenant_detail

data class TenantDetail(
    val tenantName : String?,
    val buildingName : String?,
    val area : String?,
    val contractPeriod : String?,
    val yield : String?,
    val deposit : String?,
    val monthly : String?,
    val nonPayment : String?,
    val nonPayMonths : String?,
    var isDepositCompleted : Boolean?
)
