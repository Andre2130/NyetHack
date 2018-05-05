fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    //Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    val healthstatus = formatHealthStatus(healthPoints, isBlessed)

    //player status
    printPlayerStatus(auraColor, isBlessed, name, healthstatus)

    castFireball()

}

fun castFireball(numFireballs: Int = 2) {
    println("Aglass of Fireball springs into existance. (x$numFireballs)")

}

fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "None"
    return auraColor

}

fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {

    val healthstatus = when (healthPoints){
        100 -> "is in excellent condition"
        in 90..99 -> "has a few scratches"
        in 75..89 -> if (isBlessed){
            "has some minor wounds but is healing quite quickly!"
        }else{
            "has some minor wounds"
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition"
    }
    return healthstatus
}

fun printPlayerStatus(auraColor: String, isBlessed: Boolean, name: String, healthstatus: String) {
    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "No"})")
    println("$name $healthstatus")
}
