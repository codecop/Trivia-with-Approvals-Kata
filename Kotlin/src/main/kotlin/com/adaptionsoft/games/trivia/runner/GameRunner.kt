package com.adaptionsoft.games.trivia.runner

import com.adaptionsoft.games.uglytrivia.Game
import com.adaptionsoft.games.uglytrivia.Logger
import java.util.*

object GameRunner {
    var notAWinner: Boolean = false
    val logger = Logger()
}

fun main(args: Array<String>) {
    val aGame = Game(GameRunner.logger)

    aGame.add("Chet")
    aGame.add("Pat")
    aGame.add("Sue")

    val rand = when (args.size) {
        1 -> Random(args[0].toLong())
        else -> Random()
    }

    do {

        aGame.roll(rand.nextInt(5) + 1)

        if (rand.nextInt(9) == 7) {
            GameRunner.notAWinner = aGame.wrongAnswer()
        } else {
            GameRunner.notAWinner = aGame.wasCorrectlyAnswered()
        }


    } while (GameRunner.notAWinner)

}
