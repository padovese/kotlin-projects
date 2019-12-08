package org.gypsydanger.generics

fun main(args: Array<String>) {
    val shorts: List<Short> = listOf(1, 2, 3, 4)
    val longs: List<Long> = listOf(1, 2, 3, 4)

    convertoToInt(shorts)
    convertoToInt(longs)
}

fun <T: Number> convertoToInt(list: List<T>) {
    for(e in list){
        println(e.toInt())
    }
}


