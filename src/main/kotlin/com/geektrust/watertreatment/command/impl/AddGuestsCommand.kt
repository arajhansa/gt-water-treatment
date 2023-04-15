package com.geektrust.watertreatment.command.impl

import com.geektrust.watertreatment.command.CliCommand
import com.geektrust.watertreatment.model.Apartment
import com.geektrust.watertreatment.service.ApartmentService

class AddGuestsCommand(private val apartmentService: ApartmentService) : CliCommand {
    override fun getCommandText() = "ADD_GUESTS"
    override fun execute(apartment: Apartment, inputs: Array<String>) {
        apartmentService.addGuests(apartment, inputs[0].toInt())
    }
}
