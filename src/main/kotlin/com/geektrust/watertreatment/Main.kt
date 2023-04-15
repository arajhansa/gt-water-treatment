package com.geektrust.watertreatment

import com.geektrust.watertreatment.command.CliCommandFactory
import com.geektrust.watertreatment.repository.WaterBillingRepository
import com.geektrust.watertreatment.service.impl.GeekHouseApartmentService
import com.geektrust.watertreatment.service.impl.MonthlyBillingService
import java.net.URI
import java.net.URL
import java.net.URLEncoder
import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
//    bad(args)
//    return

    val (apartmentService, cmdFactory) = run {
        val apartmentService = GeekHouseApartmentService()
        val waterBillingRepository = WaterBillingRepository()
        val billingService = MonthlyBillingService(waterBillingRepository)
        Pair(apartmentService, CliCommandFactory(apartmentService, billingService))
    }

    args.forEach { path ->
        val apartment = apartmentService.createApartment()
        Files.readAllLines(Paths.get(path)).forEach {
            it.split(" ").toTypedArray().apply {
                cmdFactory.getCommand(get(0)).execute(apartment, sliceArray(1 until size))
            }
        }
    }
}
