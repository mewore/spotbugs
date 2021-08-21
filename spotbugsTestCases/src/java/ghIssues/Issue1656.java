package ghIssues;

import edu.umd.cs.findbugs.annotations.NonNull;

@SuppressWarnings("unused")
public class Issue1656 {

    @NonNull
    public String testReturnNullInNonNullMethod() {
        return null; // expected NP_NONNULL_RETURN_VIOLATION
    }
}
