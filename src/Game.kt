fun main(args: Array<String>) {

    val player = Player("Madrigal")
    player.castFireball()

    //Aura
    val auraColor = player.auraColor()

    //player status
    printPlayerStatus(player)

}


fun printPlayerStatus(player: Player) {
    println("(Aura: $player.auraColor() " +
            "(Blessed: ${if (player.isBlessed) "YES" else "No"})")
    println("$player.name() $player.healthstatus()")
}
