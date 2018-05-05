import kotlin.math.roundToInt

const val tavernName = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

fun main(args: Array<String>) {
    placeOrder("shady,Dragon's Breath,5.91")
}

fun performPurchase(price: Double){
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    val remaningBalance = totalPurse - price
    println("Remaining balance : ${"%.2f".format(remaningBalance)}")

    val remainingGold = remaningBalance.toInt()
    val remainingSilver = (remaningBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = tavernName.indexOf('\'')
    val tavernMaster = tavernName.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

    performPurchase(price.toDouble())

    var phrase = if (name == "Dragon's Breath"){
        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "Madrigal says: Thanks for the $name"
        //"Madrigal exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    }
    println(phrase)
}

fun toDragonSpeak(phrase: String)=
        phrase.replace(Regex("[aeiou]")){

            when(it.value){
                "a"->"4"
                "e"->"3"
                "i"->"1"
                "o"->"0"
                "u"->"|_|"
                else -> it.value
            }
}
