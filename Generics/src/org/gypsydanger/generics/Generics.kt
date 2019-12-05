package org.gypsydanger.generics

fun main(args: Array<String>) {
    val list = mutableListOf("Hello")
    list.add("There")
    printList(list)
    printListUsingGenerics(list)
    list.printListUsingGenericsAndExtendedFunction()
}

fun printList(list: List<String>){
    for (e in list){
        println(e)
    }
}

fun <T> printListUsingGenerics(list: List<T>){
    for (e in list){
        println(e)
    }
}

fun <T> List<T>.printListUsingGenericsAndExtendedFunction(){
    for (e in this){
        println(e)
    }
}