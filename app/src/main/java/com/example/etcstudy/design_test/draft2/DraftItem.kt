package com.example.etcstudy.design_test.draft2

data class DraftItem(
    val buildingName : String?,
    val area : String?,
    val contractPeriod : String?,
    val yield : String?,
    val tenantName : String?,
    val ho : String?,
    val deposit : String?,
    val monthly : String?,
    val monthlyAmount : String?,
    val monthlyStatusList : List<MonthlyStatus>
)

data class MonthlyStatus(
    val month : String,
    val isEnable : Boolean,
    val isComplete : Boolean,
    val receivedAmount : String? = null,
    val remainingAmount : String? = null
)