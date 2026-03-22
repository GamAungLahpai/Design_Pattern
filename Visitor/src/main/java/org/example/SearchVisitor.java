package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchVisitor implements FileSystemVisitor {
    private final Predicate<File> criterion;
    private final List<File> matches = new ArrayList<>();

    public SearchVisitor(Predicate<File> criterion) {
        this.criterion = criterion;
    }

    @Override
    public void visitFile(File file) {
        if (criterion.test(file)) {
            matches.add(file);
        }
    }

    @Override
    public void visitDirectory(Directory directory) {
        // Search applies to files in this assignment.
    }

    public List<File> getMatches() {
        return List.copyOf(matches);
    }
}

