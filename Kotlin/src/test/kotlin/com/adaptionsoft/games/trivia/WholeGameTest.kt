package com.adaptionsoft.games.trivia

import com.adaptionsoft.games.trivia.runner.GameRunner
import com.adaptionsoft.games.trivia.runner.main
import org.approvaltests.Approvals
import org.junit.Test

class WholeGameTest {

    @Test
    fun plays_trivia_seed1() {
        val args = arrayOf("93898394832")
        main(args)
        Approvals.verify(GameRunner.logger.logsAsString())
    }

    @Test
    fun plays_trivia_seed2() {
        val args = arrayOf("810938938")
        main(args)
        Approvals.verify(GameRunner.logger.logsAsString())
    }

    @Test
    fun plays_trivia_seed3() {
        val args = arrayOf("8173453")
        main(args)
        Approvals.verify(GameRunner.logger.logsAsString())
    }

    @Test
    fun plays_trivia_seed4() {
        val args = arrayOf("76298317238")
        main(args)
        Approvals.verify(GameRunner.logger.logsAsString())
    }
}
