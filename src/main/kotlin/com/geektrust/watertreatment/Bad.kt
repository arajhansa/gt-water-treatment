package com.geektrust.watertreatment

import java.nio.file.Files
import java.nio.file.Paths

fun bad(args: Array<String>) {
    args.forEach { path ->
        val lines = Files.readAllLines(Paths.get(path))
        var headCount = 0
        var ratio = 0.0
        var allocation = 0
        lines.forEach {
            val inputs = it.split(" ")
            when (inputs[0]) {
                "ALLOT_WATER" -> {
                    when (inputs[1].toInt()) {
                        2 -> {
                            headCount += 3; allocation = 900
                        }
                        3 -> {
                            headCount += 5; allocation = 1500
                        }
                    }
                    ratio =
                        inputs[2].split(":")[0].toDouble() / (inputs[2].split(":")[0].toDouble() + inputs[2].split(":")[1].toDouble())
                }
                "ADD_GUESTS" -> {
                    headCount += inputs[1].toInt()
                }
                "BILL" -> {
                    val totalQuantity = 300 * headCount

                    var amount = 0
                    amount += (allocation * ratio).toInt()
                    amount += (allocation * (1 - ratio) * 1.5).toInt()

                    var quantity = totalQuantity - allocation
                    if (quantity > 3000) {
                        amount += (quantity - 3000) * 8
                        quantity -= (quantity - 3000)
                    }
                    if (quantity > 1500) {
                        amount += (quantity - 1500) * 5
                        quantity -= (quantity - 1500)
                    }
                    if (quantity > 500) {
                        amount += (quantity - 500) * 3
                        quantity -= (quantity - 500)
                    }
                    if (quantity > 0) {
                        amount += quantity * 2
                    }

                    println("$totalQuantity $amount")
                }
                else -> {
                    println("INVALID COMMAND")
                }
            }
        }
    }
}
