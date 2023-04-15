package com.geektrust.watertreatment.service

import com.geektrust.watertreatment.model.Apartment

interface ApartmentService {
    fun createApartment(): Apartment
    fun addGuests(apartment: Apartment, count: Int)
    fun allotWaterRatio(apartment: Apartment, ratio: String)
    fun setApartmentConfig(apartment: Apartment, roomCount: Int)
}
