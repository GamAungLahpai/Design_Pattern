package org.example;

public class Book implements Cloneable {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;

    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    // Copy constructor (alternative cloning method)
    public Book(Book other) {
        this.title = other.title;
        this.author = other.author;
        this.genre = other.genre;
        this.publicationYear = other.publicationYear;
    }

    @Override
    public Book clone() {
        return new Book(this); // deep copy of Book
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + genre + ", " + publicationYear + ")";
    }
}