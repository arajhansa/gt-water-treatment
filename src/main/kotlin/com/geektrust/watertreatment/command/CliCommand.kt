package com.geektrust.watertreatment.command

import com.geektrust.watertreatment.model.Apartment
import com.geektrust.watertreatment.service.ApartmentService
import com.geektrust.watertreatment.service.BillingService

interface CliCommand {
    fun getCommandText(): String
    fun execute(apartment: Apartment, inputs: Array<String>): Any
}
