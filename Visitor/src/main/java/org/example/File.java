package org.example;

public class File implements FileSystemElement {
    private final String name;
    private final double sizeInMb;

    public File(String name, double sizeInMb) {
        this.name = name;
        this.sizeInMb = sizeInMb;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getSizeInMb() {
        return sizeInMb;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitFile(this);
    }
}

