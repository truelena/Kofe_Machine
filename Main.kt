package machine

var water = 400
var milk = 540
var coffeeBeans = 120
var cups = 9
var money = 550

fun lackOfWater() = println("Sorry, not enough water!")
fun lackOfCoffee() = println("Sorry, not enough coffee!")
fun lackOfMilk() = println("Sorry, not enough milk!")
fun lackOfCups() = println("Sorry, not enough cups!")
fun enoughResourses() = println("I have enough resources, making you a coffee!")


fun buyCoffee() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    when (readln()) {
        "1" -> espresso()
        "2" -> latte()
        "3" -> cappuccino()
        "back" -> return
    }
}


fun fill() {
    println("Write how many ml of water you want to add:")
    water += readln().toInt()
    println("Write how many ml of milk you want to add:")
    milk += readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    coffeeBeans += readln().toInt()
    println("Write how many disposable cups you want to add:")
    cups += readln().toInt()
}


fun takeMoney() {
    println("I gave you $$money")
    money = 0
}


fun remaining() {
    println(
        """
            The coffee machine has:
            $water ml of water
            $milk ml of milk
            $coffeeBeans g of coffee beans
            $cups disposable cups
            $$money of money
        """.trimIndent()
    )
}

/* Variety of coffees */
fun espresso() {
    if (water < 250 || coffeeBeans < 16 || cups < 1) {
        when {
            water < 250 -> lackOfWater()
            coffeeBeans < 16 -> lackOfCoffee()
            cups < 1 -> lackOfCups()
        }
    } else {
        water -= 250
        coffeeBeans -= 16
        cups -= 1
        money += 4
        enoughResourses()
    }
}

fun latte() {
    if (water < 350 || milk < 75 || coffeeBeans < 20 || cups < 1) {
        when {
            water < 350 -> println("Sorry, not enough water!")
            milk < 75 -> println("Sorry, not enough milk!")
            coffeeBeans < 20 -> println("Sorry, not enough coffee beans!")
            cups < 1 -> println("Sorry, not enough cups!")
        }
    } else {
        water -= 350
        milk -= 75
        coffeeBeans -= 20
        cups -= 1
        money += 7
        enoughResourses()
    }
}

fun cappuccino() {
    if (water < 200 || milk < 100 || coffeeBeans < 12 || cups < 1) {
        when {
            water < 200 -> lackOfWater()
            milk < 100 -> lackOfMilk()
            coffeeBeans < 12 -> lackOfCoffee()
            cups < 1 -> lackOfCups()
        }
    } else {
        water -= 200
        milk -= 100
        coffeeBeans -= 12
        cups -= 1
        money += 6
        enoughResourses()
    }
}
// Main program
fun main() {
    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        when (readln()) {
            "buy" -> buyCoffee()
            "fill" -> fill()
            "take" -> takeMoney()
            "remaining" -> remaining()
            "exit" -> break
        }
    }
}
