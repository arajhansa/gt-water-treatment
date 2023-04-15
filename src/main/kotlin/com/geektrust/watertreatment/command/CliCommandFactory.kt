package com.geektrust.watertreatment.command

import com.geektrust.watertreatment.command.impl.AddGuestsCommand
import com.geektrust.watertreatment.command.impl.AllotWaterCommand
import com.geektrust.watertreatment.command.impl.BillCommand
import com.geektrust.watertreatment.service.ApartmentService
import com.geektrust.watertreatment.service.BillingService

class CliCommandFactory(apartmentService: ApartmentService, billingService: BillingService) {
    private val commands = listOf(
        AddGuestsCommand(apartmentService),
        AllotWaterCommand(apartmentService),
        BillCommand(billingService),
    )

    fun getCommand(name: String): CliCommand =
        commands.find { it.getCommandText() == name } ?: throw IllegalStateException("INVALID COMMAND")
}
