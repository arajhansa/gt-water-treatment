package com.geektrust.watertreatment.service

import com.geektrust.watertreatment.model.Apartment
import com.geektrust.watertreatment.model.WaterBill

interface BillingService {
    fun generateBill(apartment: Apartment): WaterBill
}
