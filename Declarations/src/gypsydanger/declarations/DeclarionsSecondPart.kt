package gypsydanger.declarations

fun main(args: Array<String>) {

    //Equivalent of && and ||
    if (true and false) {
        println("and")
    }

    if (true or false) {
        println("or")
    }

    //cast
    val pa = Employeee("Pa", 123)
    pa is Any //when you check, Kotlin do autocasting
    pa as Any //this is other way

    println(pa is Any)

    println(pa)
    println(pa.name)


    val dollar = 4.12
    println("In order to print the value, just use $dollar, and to scape use \$dollar")

    val amountOfDollars = 1000
    println("If I buy $amountOfDollars dollars I will have to pay ${dollar * amountOfDollars}")
    println("To access an attribute inside an object use ${pa.name}")

    val tripleQuotes = """This is awesome, you don't need to scape nothing l
        *ike c:\\my\\path you can just use c:\my\path or even break the line
        *like this is okay""".trimMargin("*")

    println(tripleQuotes)
}

class Employeee(val name: String, val id: Int) {

    //How override methods looks like
    override fun toString(): String {
        return "Employe(name=$name, id=$id) "
    }
}