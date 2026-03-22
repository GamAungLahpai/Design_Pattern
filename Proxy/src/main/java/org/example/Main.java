package org.example;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Create users
        User alice = new User("alice");
        User bob = new User("bob");
        User charlie = new User("charlie");

        // Set up access control
        AccessControlService acs = AccessControlService.getInstance();

        // Library setup
        Library library = new Library();

        // Unprotected document
        RealDocument publicDoc = new RealDocument(
                "public-1",
                LocalDateTime.now().minusDays(1),
                "This is a public document. Anyone can read this."
        );
        library.addUnprotectedDocument(publicDoc);

        // Protected documents (stored as proxies in the library)
        Document secretReport = library.createProtectedDocument(
                "secret-report",
                LocalDateTime.now().minusHours(2),
                "Top secret report: Project X launch details."
        );

        Document confidentialPlan = library.createProtectedDocument(
                "confidential-plan",
                LocalDateTime.now().minusHours(1),
                "Confidential plan: Expansion strategy for next quarter."
        );

        // Configure permissions
        acs.allow("alice", "secret-report");
        acs.allow("alice", "confidential-plan");

        acs.allow("bob", "secret-report");
        // bob does NOT get access to confidential-plan

        // charlie gets no permissions for protected docs

        // Demonstrate accesses
        demonstrateAccess(library, alice, "public-1");
        demonstrateAccess(library, alice, "secret-report");
        demonstrateAccess(library, alice, "confidential-plan");

        demonstrateAccess(library, bob, "public-1");
        demonstrateAccess(library, bob, "secret-report");
        demonstrateAccess(library, bob, "confidential-plan");

        demonstrateAccess(library, charlie, "public-1");
        demonstrateAccess(library, charlie, "secret-report");
        demonstrateAccess(library, charlie, "confidential-plan");

        // Attempt to access a non-existing document
        demonstrateAccess(library, alice, "non-existing");
    }

    private static void demonstrateAccess(Library library, User user, String documentId) {
        System.out.println("\nUser '" + user.getUsername() + "' tries to access document '" + documentId + "'");
        Document doc = library.getDocument(documentId);
        if (doc == null) {
            System.out.println("Document with id '" + documentId + "' does not exist in the library.");
            return;
        }
        System.out.println("Creation date: " + doc.getCreationDate());
        try {
            String content = doc.getContent(user);
            System.out.println("Access granted. Content: " + content);
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}