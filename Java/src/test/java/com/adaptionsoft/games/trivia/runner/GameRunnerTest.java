package com.adaptionsoft.games.trivia.runner;

import java.util.Random;
import java.util.stream.IntStream;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.approvaltests.reporters.macosx.KDiff3Reporter;
import org.junit.Rule;
import org.junit.Test;

@UseReporter(value = { KDiff3Reporter.class, QuietReporter.class })
public class GameRunnerTest {

    private static final int NUM_TESTS = 1000;
    
    @Rule
    public CaptureSystemOut stdOut = new CaptureSystemOut();

    @Test
    public void playsTrivia() {
        IntStream.range(1, NUM_TESTS). //
                map(i -> 147621 + 13 * i). //
                mapToObj(Random::new). //
                forEach(GameRunner::main);

        Approvals.verify(stdOut.asString());
    }

}
