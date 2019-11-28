package org.gypsydanger.inheritance

//This is can example of extended class
//open is like public. The default class is a final, so it cannot be extended.

open class Printer(val modelName: String){}

class laserPrinter(modelName: String): Printer(modelName){}

/**************************/

//using abstract class
abstract class Printer2(val modelName: String){
    fun printModel() = println("the model name is $modelName")
}

class laserPrinter2(modelName: String): Printer2(modelName){}

/************************/

//override a method
abstract class Printer3(val modelName: String){
    open fun printModel() = println("the model name is $modelName")
    abstract fun bestPrice(): Double
}

class laserPrinter3(modelName: String): Printer3(modelName){
    override fun printModel() = println("the printer model name is $modelName")
    override fun bestPrice(): Double = 129.99
}

fun main(args: Array<String>) {
    laserPrinter2("model1").printModel()
    laserPrinter3("model1").printModel()
}