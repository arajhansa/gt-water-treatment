package com.geektrust.watertreatment.command.impl

import com.geektrust.watertreatment.command.CliCommand
import com.geektrust.watertreatment.model.Apartment
import com.geektrust.watertreatment.service.BillingService

class BillCommand(private val billingService: BillingService) : CliCommand {
    override fun getCommandText() = "BILL"
    override fun execute(apartment: Apartment, inputs: Array<String>) {
        billingService.generateBill(apartment).also { println("${it.monthlyUsage} ${it.amount}") }
    }
}
