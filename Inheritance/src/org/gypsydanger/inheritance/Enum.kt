package org.gypsydanger.inheritance

enum class FirstEnum{
    HR, IT, ACCOUNTING, SALES
}

enum class SecondEnum(val fullName: String, val numEmployees: Int){
    HR("Human Resources", 5),
    IT("Information Technology", 10),
    ACCOUNTING("Accounting", 3),
    SALES("Sales", 20);

    fun getDeptInfo() = "The $fullName department has $numEmployees employees"
}

fun main(args: Array<String>) {
    println(FirstEnum.ACCOUNTING)
    println(SecondEnum.ACCOUNTING.getDeptInfo())
}