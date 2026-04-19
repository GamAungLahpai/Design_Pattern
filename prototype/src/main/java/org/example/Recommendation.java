package org.example;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    // Copy constructor for deep clone
    public Recommendation(Recommendation other) {
        this.targetAudience = other.targetAudience;
        this.books = new ArrayList<>();

        for (Book book : other.books) {
            this.books.add(book.clone()); // deep copy each book
        }
    }

    @Override
    public Recommendation clone() {
        return new Recommendation(this);
    }

    // Methods to modify cloned object
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.remove(index);
        }
    }

    public void setTargetAudience(String audience) {
        this.targetAudience = audience;
    }

    public void display() {
        System.out.println("Audience: " + targetAudience);
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }
}
