package com.geektrust.watertreatment.service.impl

import com.geektrust.watertreatment.model.Apartment
import com.geektrust.watertreatment.model.WaterBill
import com.geektrust.watertreatment.repository.WaterBillingRepository
import com.geektrust.watertreatment.service.BillingService

class MonthlyBillingService(private val waterPricing: WaterBillingRepository) : BillingService {
    private val numberOfDaysInMonth = 30
    private val perPersonDefaultAllocation = 10

    override fun generateBill(apartment: Apartment): WaterBill {
        val headCount = apartment.getHeadCount()
        val totalQuantity = numberOfDaysInMonth * perPersonDefaultAllocation * headCount
        var amount = apartment.getMonthlyAmount()
        var quantity = totalQuantity - apartment.monthlyWaterAllocation()
        waterPricing.getWaterTankerBillingSlabs().sortedByDescending { it.from }.forEach {
            if (quantity > it.from) {
                amount += (quantity - it.from) * it.amount
                quantity -= (quantity - it.from)
            }
        }

        return WaterBill(totalQuantity, amount)
    }

    private fun Apartment.getHeadCount() = config.capacity + guests

    private fun Apartment.monthlyWaterAllocation() = config.capacity * numberOfDaysInMonth * perPersonDefaultAllocation

    private fun Apartment.calculateMonthlyAmount(ratio: Double, unitPrice: Double) =
        (monthlyWaterAllocation() * ratio * unitPrice).toInt()

    private fun Apartment.getMonthlyAmount() =
        calculateMonthlyAmount(corporationAllotmentRatio, waterPricing.getCorporationWaterUnitPrice()) +
        calculateMonthlyAmount(boringAllotmentRatio(), waterPricing.getBoringWaterUnitPrice())
}
