import java.lang.IllegalStateException

fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    val isJugglingProficent = (1..3).shuffled().last() == 3
    if(isJugglingProficent){
        swordsJuggling = 2
    }

    proficiencyCheck(swordsJuggling)
    swordsJuggling = swordsJuggling!!.plus(1)
    println("You Juggle $swordsJuggling swords")
}

fun proficiencyCheck(swordsJuggling: Int?) {
    swordsJuggling ?: throw unskilledSwordException()
    checkNotNull(swordsJuggling, {"Player cannot juggle swords"})
}

class unskilledSwordException() :
        IllegalStateException("Player cannot juggle swords")
