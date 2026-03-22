package org.example;

public interface FileSystemElement {
    String getName();
    void accept(FileSystemVisitor visitor);
}

