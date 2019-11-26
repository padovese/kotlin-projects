package com.gypsydanger.challenge2

fun main() {
    val flt: Float
    flt = 3847.384f
    val flt2 = 3847.384f

    val flt3: Float?
    flt3 = 3847.384f
    val flt4: Float? = 3847.384f

    val arr: Array<Short>? = arrayOf(1,2,3,4,5)

    val arr2 = Array<Int?>(40){i -> (i+1)*5}

    val arr3 = charArrayOf('a', 'b', 'c')

    val x: String? = "I AM IN UPPERCASE"
    val y = x?.toLowerCase() ?: "I give up"

    x?.let { println(it.toLowerCase()) } //same thing but with let

    val myNonNullVariable: Int? = null
    myNonNullVariable!!.toDouble()
}