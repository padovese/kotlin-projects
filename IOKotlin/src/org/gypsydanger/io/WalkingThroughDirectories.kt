package org.gypsydanger.io

import java.io.File

fun main(args: Array<String>) {
    //print the "." all the files in this project
    File(".").walkTopDown().forEach { println(it) }


    //print only the kotlin files
    File(".").walkTopDown()
        .filter { it.name.endsWith(".kt") }
        .forEach { println(it) }
}