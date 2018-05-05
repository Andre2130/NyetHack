const val tavernName = "Taernyl's Folly"

fun main(args: Array<String>) {
    placeOrder()
}

private fun placeOrder() {
    val indexOfApostrophe = tavernName.indexOf('\'')
    val tavernMaster = tavernName.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")
}
