package sample;

import java.util.Arrays;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.approvaltests.reporters.macosx.KDiff3Reporter;
import org.junit.Test;

@UseReporter(value = { KDiff3Reporter.class, QuietReporter.class })
public class SampleArrayTest {

    @Test
    public void testList() {
        String[] names = { "Llewellyn", "James", "Dan", "Jason", "Katrina" };
        Arrays.sort(names);
        Approvals.verifyAll("", names);
    }

}
