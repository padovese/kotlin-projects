package org.gypsydanger.io

import java.io.File

fun main(args: Array<String>) {
    val lines = File("testfile.txt").reader().readLines()
    lines.forEach { println(it) }


    val text = File("testfile.txt").reader().readText()
    println(text)

    File("testfile.txt").reader().use { println(it.readText()) }
    File("testfile.txt").bufferedReader().use { println(it.readText()) }

    println(File("testfile.txt").readText()) //best way, but the limit using this is 2GB
}