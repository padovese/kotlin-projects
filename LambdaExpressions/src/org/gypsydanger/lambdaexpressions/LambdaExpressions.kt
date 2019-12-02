package org.gypsydanger.lambdaexpressions

fun main(args: Array<String>) {
    val employees = listOf(
        Employee("Bruce", "Wayne", 2010),
        Employee("Clark", "kent", 2009),
        Employee("Hal", "Jordan", 2014),
        Employee("Barry", "Allen", 2019)
    )

    //the 3 lines do the same thing
    println(employees.minBy { e -> e.startYear })
    println(employees.minBy { it.startYear })
    println(employees.minBy(Employee::startYear))
}

data class Employee(val firstName: String, val lastName: String, val startYear: Int)