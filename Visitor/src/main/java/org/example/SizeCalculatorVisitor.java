package org.example;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSizeInMb;

    @Override
    public void visitFile(File file) {
        totalSizeInMb += file.getSizeInMb();
    }

    @Override
    public void visitDirectory(Directory directory) {
        // No directory size; total is based on contained files.
    }

    public double getTotalSizeInMb() {
        return totalSizeInMb;
    }
}

