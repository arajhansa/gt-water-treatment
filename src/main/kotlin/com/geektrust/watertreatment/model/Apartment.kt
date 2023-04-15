package com.geektrust.watertreatment.model

data class Apartment(
    var config: ApartmentConfig = ApartmentConfig.get(2),
    var corporationAllotmentRatio: Double = 0.0,
    var guests: Int = 0,
) {
    fun boringAllotmentRatio() = 1 - corporationAllotmentRatio
}

data class ApartmentConfig(
    val rooms: Int,
    val capacity: Int,
) {
    companion object {
        private val capacities = listOf(
            ApartmentConfig(2, 3),
            ApartmentConfig(3, 5),
        )

        fun get(roomCount: Int) = capacities.find { it.rooms == roomCount } ?: ApartmentConfig(2, 3)
    }
}
