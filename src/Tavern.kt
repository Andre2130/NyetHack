const val tavernName = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

fun main(args: Array<String>) {
    placeOrder("shady, Dragon's Breath, 5.91")
}

fun performPurchase(){
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

    performPurchase()

    var phrase = if(name == "Dragon's Breath"){
        "Madrigal exclaims ${toDradgonSpeak("Ah, delicious $name!")}"
    }else{
        "Madrigal says: Thanks for the $name"
    }
    println(phrase)
}

fun toDradgonSpeak(phrase: String)=
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
