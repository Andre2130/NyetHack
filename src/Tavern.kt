import kotlin.math.roundToInt

const val tavernName = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")

fun main(args: Array<String>) {
    if (patronList.contains("Eli")){
        println("The Tavern master says: Eli's in the back playing cards")
    } else {
        println("The tavern master says: Eli isn't here.")
    }

    if (patronList.containsAll(listOf("Sophie", "Mordoc"))){
        println("The Taver master says: Yae, they're seated by the stew kettle.")
    } else {
        println("The Taver master says: Nay, they departed hours ago.")
    }



    /*println(patronList)
    patronList.remove("Eli")
    patronList.add(0, "Alex")
    patronList[0] = "Alexis"
    println(patronList)*/
    /*for (patron in patronList){
        println("Good evening, $patron")
    }*/
    patronList.forEachIndexed() { index, patron ->
        println("Good evening, $patron - you're on #${index + 1} in line.")
        //spacing is important caused an error in if statement whene I had "Shady, Dragon's Breath, 5.91
        placeOrder("shady,Dragon's Breath,5.91")
    }

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
