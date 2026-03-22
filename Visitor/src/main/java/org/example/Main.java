package org.example;


class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory docs = new Directory("docs");
        Directory images = new Directory("images");

        root.add(new File("notes.txt", 1.2));
        docs.add(new File("report.pdf", 2.8));
        docs.add(new File("todo.txt", 0.5));
        images.add(new File("diagram.png", 3.4));
        root.add(docs);
        root.add(images);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSizeInMb() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(file -> file.getName().endsWith(".txt"));
        root.accept(searchVisitor);

        System.out.println("TXT files found:");
        for (File match : searchVisitor.getMatches()) {
            System.out.println("- " + match.getName() + " (" + match.getSizeInMb() + " MB)");
        }
    }
}