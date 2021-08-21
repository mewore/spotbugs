package edu.umd.cs.findbugs.nullness;

import edu.umd.cs.findbugs.AbstractIntegrationTest;
import edu.umd.cs.findbugs.BugCollection;
import edu.umd.cs.findbugs.test.matcher.BugInstanceMatcher;
import edu.umd.cs.findbugs.test.matcher.BugInstanceMatcherBuilder;
import org.junit.Test;

import static edu.umd.cs.findbugs.test.CountMatcher.containsExactly;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test to reproduce <a href="https://github.com/spotbugs/spotbugs/issues/1657">#1657</a>.
 */
public class Issue1657Test extends AbstractIntegrationTest {

    @Test
    public void test() {
        performAnalysis("ghIssues/Issue1657.class");
        final BugCollection bugCollection = getBugCollection();

        final BugInstanceMatcher bugTypeMatcher = new BugInstanceMatcherBuilder()
                .bugType("NP_NONNULL_RETURN_VIOLATION").build();
        assertThat(bugCollection, containsExactly(2, bugTypeMatcher));
    }
}
