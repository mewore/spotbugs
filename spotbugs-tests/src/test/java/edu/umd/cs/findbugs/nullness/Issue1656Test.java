package edu.umd.cs.findbugs.nullness;

import edu.umd.cs.findbugs.AbstractIntegrationTest;
import edu.umd.cs.findbugs.BugCollection;
import edu.umd.cs.findbugs.test.matcher.BugInstanceMatcher;
import edu.umd.cs.findbugs.test.matcher.BugInstanceMatcherBuilder;
import org.junit.Test;

import static edu.umd.cs.findbugs.test.CountMatcher.containsExactly;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test to reproduce <a href="https://github.com/spotbugs/spotbugs/issues/1656">#1656</a>.
 */
public class Issue1656Test extends AbstractIntegrationTest {

    @Test
    public void test() {
        performAnalysis("ghIssues/Issue1656.class");
        final BugCollection bugCollection = getBugCollection();

        final BugInstanceMatcher bugTypeMatcher = new BugInstanceMatcherBuilder()
                .bugType("NP_NONNULL_RETURN_VIOLATION").build();
        assertThat(bugCollection, containsExactly(1, bugTypeMatcher));
    }
}
