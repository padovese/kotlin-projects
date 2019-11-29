package org.gypsydanger.inheritance

class SomeClass private constructor(val someString: String){

    companion object{
        private var privateVar = 6

        fun accessPrivateVar() = "I'm accessing privateVar: $privateVar"

        fun justAssign(str: String) = SomeClass(str)
        fun upperOrLowerCase(str: String, upperCase: Boolean): SomeClass{
            return if(upperCase){
                SomeClass(str.toUpperCase())
            } else{
                SomeClass(str)
            }
        }
    }
}

fun main(args: Array<String>) {
    val someClass1 = SomeClass.justAssign("abc")
    println(someClass1.someString)

    val someClass2 = SomeClass.upperOrLowerCase("abc", true)
    println(someClass2.someString)
}