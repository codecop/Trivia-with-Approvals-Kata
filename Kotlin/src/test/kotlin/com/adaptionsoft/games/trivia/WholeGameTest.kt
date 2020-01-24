package com.adaptionsoft.games.trivia

import com.adaptionsoft.games.trivia.runner.GameRunner
import com.adaptionsoft.games.trivia.runner.main
import org.approvaltests.Approvals
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class WholeGameTest {

    var out: PrintStream? = null
    var stdOut: ByteArrayOutputStream? = null

    @Before
    fun before() {
        out = System.out
        stdOut = ByteArrayOutputStream()
        System.setOut(PrintStream(stdOut))
    }

    @After
    fun after() {
        System.setOut(out)
    }

    fun logsAsString(): String {
        return stdOut.toString()
    }

    @Test
    fun plays_trivia_seed1() {
        val args = arrayOf("93898394832")
        main(args)
        Approvals.verify(logsAsString())
    }

    @Test
    fun plays_trivia_seed2() {
        val args = arrayOf("810938938")
        main(args)
        Approvals.verify(logsAsString())
    }

    @Test
    fun plays_trivia_seed3() {
        val args = arrayOf("8173453")
        main(args)
        Approvals.verify(logsAsString())
    }

    @Test
    fun plays_trivia_seed4() {
        val args = arrayOf("76298317238")
        main(args)
        Approvals.verify(logsAsString())
    }
}
