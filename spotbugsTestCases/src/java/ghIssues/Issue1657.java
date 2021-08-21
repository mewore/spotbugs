package ghIssues;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Issue1657 {

    public @NonNull String testReturnNullFromListInNonNullMethod() {
        final List<@Nullable String> nullableStringList = new ArrayList<>();
        nullableStringList.add(null);
        return nullableStringList.get(0); // expected NP_NONNULL_RETURN_VIOLATION
    }

    public @NonNull String testReturnNullInNonNullMethod() {
        return null; // expected NP_NONNULL_RETURN_VIOLATION
    }
}