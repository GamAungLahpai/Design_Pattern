package org.example;

public interface FileSystemVisitor {
    void visitFile(File file);
    void visitDirectory(Directory directory);
}

