package com.adaptionsoft.games.trivia.runner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.approvaltests.reporters.macosx.KDiff3Reporter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
@UseReporter(value = { KDiff3Reporter.class, QuietReporter.class })
public class GameRunnerTest {

    @Parameters(name = "random seed {0}")
    public static Collection<Object[]> seeds() {
        return IntStream.range(1, 100). //
                map(i -> 147621 + 13 * i). //
                mapToObj(i -> new Object[] { i, new Random(i) }). //
                collect(Collectors.toList());
    }

    @Parameter(0)
    public int seed;
    @Parameter(1)
    public Random random;

    private PrintStream out;
    private ByteArrayOutputStream stdOut;

    @Before
    public void redirectOut() {
        out = System.out;
        stdOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdOut));
    }

    @After
    public void resetOut() {
        System.setOut(out);
    }

    @Test
    public void playsTrivia() {
        GameRunner.main(random);
        Approvals.verify(stdOut.toString());
    }

}
