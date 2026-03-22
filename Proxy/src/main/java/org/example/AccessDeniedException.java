package org.example;

/**
 * Thrown when a user attempts to access a protected document without permission.
 */
public class AccessDeniedException extends Exception {

    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException(String username, String documentId) {
        super("Access denied for user '" + username + "' to document '" + documentId + "'.");
    }
}

