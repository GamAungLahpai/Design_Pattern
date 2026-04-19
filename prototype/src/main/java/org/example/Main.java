package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Recommendation> recommendations = new ArrayList<>();

        // Initial prototype
        Recommendation fantasyList = new Recommendation("Fantasy Lovers");
        fantasyList.addBook(new Book("Harry Potter", "J.K. Rowling", "Fantasy", 1997));
        fantasyList.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937));

        recommendations.add(fantasyList);

        while (true) {
            System.out.println("\n1. View Recommendations");
            System.out.println("2. Clone Recommendation");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < recommendations.size(); i++) {
                        System.out.println("\nIndex: " + i);
                        recommendations.get(i).display();
                    }
                    break;

                case 2:
                    System.out.print("Enter index to clone: ");
                    int index = scanner.nextInt();

                    if (index >= 0 && index < recommendations.size()) {
                        Recommendation cloned = recommendations.get(index).clone();

                        scanner.nextLine(); // clear buffer
                        System.out.print("New audience: ");
                        String audience = scanner.nextLine();

                        cloned.setTargetAudience(audience);

                        // Example modification
                        cloned.addBook(new Book("New Book", "Unknown", "Custom", 2024));

                        recommendations.add(cloned);

                        System.out.println("Cloned and modified successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 3:
                    return;
            }
        }
    }
}