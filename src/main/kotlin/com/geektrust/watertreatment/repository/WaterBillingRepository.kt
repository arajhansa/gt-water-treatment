package com.geektrust.watertreatment.repository

class WaterBillingRepository {
    fun getCorporationWaterUnitPrice() = 1.0
    fun getBoringWaterUnitPrice() = 1.5
    fun getWaterTankerBillingSlabs() = WaterTankerBillingSlabs.slabs
}

class WaterTankerBillingSlabs(
    val from: Int,
    val amount: Int,
) {
    companion object {
        val slabs = listOf(
            WaterTankerBillingSlabs(0, 2),
            WaterTankerBillingSlabs(500, 3),
            WaterTankerBillingSlabs(1500, 5),
            WaterTankerBillingSlabs(3000, 8),
        )
    }
}