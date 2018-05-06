import java.util.*

interface Fightable{
    var healthPoints: Int
    val diceCount: Int
    val diceSide: Int
    val damageRoll: Int
    get() = (0 until diceCount).map {
        Random().nextInt(diceSide + 1)
    }.sum()

    fun attack(opponent: Fightable): Int
}

abstract class Monster(val name: String,
                       val description: String,
                       override var healthPoints: Int) : Fightable{
    override  fun attack(opponent: Fightable): Int {
        val damageDealt = damageRoll
        opponent.healthPoints -= damageDealt
        return damageDealt
    }
}

class Goblin(name: String = "Goblin",
             description: String = "A nasty looking Goblin",
             healthPoints: Int = 30) : Monster(name, description, healthPoints){
    override val diceCount: Int = 2
    override val diceSide: Int = 8
}