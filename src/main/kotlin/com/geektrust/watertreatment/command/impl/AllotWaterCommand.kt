package com.geektrust.watertreatment.command.impl

import com.geektrust.watertreatment.command.CliCommand
import com.geektrust.watertreatment.model.Apartment
import com.geektrust.watertreatment.service.ApartmentService

class AllotWaterCommand(private val apartmentService: ApartmentService) : CliCommand {
    override fun getCommandText() = "ALLOT_WATER"
    override fun execute(apartment: Apartment, inputs: Array<String>) {
        apartmentService.setApartmentConfig(apartment, inputs[0].toInt())
        apartmentService.allotWaterRatio(apartment, inputs[1])
    }
}
