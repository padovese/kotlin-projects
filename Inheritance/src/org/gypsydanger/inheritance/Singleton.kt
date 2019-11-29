package org.gypsydanger.inheritance

import java.time.Year

object Singleton{
    val currentYear = Year.now().value

    fun getTagLine() = "Our company rocks!"
    fun getCopyRight() = "Copyright \u00A9 $currentYear Our Company. All rights reserved"
}

fun main(args: Array<String>) {
    println(Singleton.currentYear)
    println(Singleton.getCopyRight())
}