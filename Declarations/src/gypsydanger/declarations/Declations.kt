package gypsydanger.declarations

fun main(args: Array<String>) {
    val number = 10     //val is a constant, immutable
    val number2:Int
    number2 = 5
    val number3:Int = 2

    var number4 = 20    //var is a variable, mutable
    number4 = 30

    println(number)
    println(number2)
    println(number3)
    println(number4)

    val joseph : Employeee
    joseph = Employeee("Joseph", 6541)

    val giorgio = Employeee("Giorgio", 646)

    println(joseph.toString())
    println(giorgio.toString())

    if(1 > 2){
        println("a")
    } else{
        println("b")
    }

    //In Kotlin, there is no ternary, no for loops, no 'new' keyword,
    // String class here is different from String from Java

    println(joseph is Employeee) //Equivalent to instanceof


    val vito = "Vito"

    println("Vito" == vito)     //is the same as equals
    println("Vito" === vito)    //here it is checking the object reference
    //the same goes for != and !==
}

class Employee(name : String, id : Int){

}