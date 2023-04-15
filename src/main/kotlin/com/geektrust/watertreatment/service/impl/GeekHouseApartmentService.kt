package com.geektrust.watertreatment.service.impl

import com.geektrust.watertreatment.model.Apartment
import com.geektrust.watertreatment.model.ApartmentConfig
import com.geektrust.watertreatment.service.ApartmentService

class GeekHouseApartmentService : ApartmentService {
    override fun createApartment() = Apartment()

    override fun addGuests(apartment: Apartment, count: Int) =
        apartment.run { guests += count }

    override fun setApartmentConfig(apartment: Apartment, roomCount: Int) =
        apartment.run { config = ApartmentConfig.get(roomCount) }

    override fun allotWaterRatio(apartment: Apartment, ratio: String) =
        apartment.run { corporationAllotmentRatio = ratio.allotment() }

    private fun String.allotment() = split(":").run { get(0).toDouble() / (get(0).toDouble() + get(1).toDouble()) }
}
