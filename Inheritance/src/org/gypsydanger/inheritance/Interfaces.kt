package org.gypsydanger.inheritance

interface FirstInterface {
    val num: Int
    fun firstMethod(): String
}

class FirstClass : FirstInterface{
    override val num: Int = 0   //this assign could be in constructor as well, without value associated
    override fun firstMethod(): String = "abc"
}