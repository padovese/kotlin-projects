package org.gypsydanger.accessmodifiers

fun main(args: Array<String>) {
    val padova = Employee(name = "Padovese")
    println(padova.name)
    val emp1 = Employee3("Padovese")
    val emp2 = Employee3("Padovese", true)
    println(emp1.name)
    println("${emp2.name + " " +  emp2.fullTime}")
}

class Employee (val name: String){

}

class Employee2 private constructor(val name: String) {
    //if you need to change the access modifier of the constructor...
}

class Employee3(val name: String, val fullTime: Boolean = false){
    //This is like a overload constructor, you need to set a default value in case the user doesnt
}