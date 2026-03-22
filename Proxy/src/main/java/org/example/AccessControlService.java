package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Singleton service that controls which users are allowed to access which documents.
 */
public final class AccessControlService {

    private static AccessControlService instance;

    // Map from username -> set of allowed document IDs
    private final Map<String, Set<String>> permissions = new HashMap<>();

    private AccessControlService() {
    }

    public static synchronized AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    /**
     * Grants access for the given user to the given document ID.
     */
    public synchronized void allow(String username, String documentId) {
        permissions.computeIfAbsent(username, u -> new HashSet<>()).add(documentId);
    }

    /**
     * Revokes access for the given user to the given document ID, if present.
     */
    public synchronized void revoke(String username, String documentId) {
        Set<String> docs = permissions.get(username);
        if (docs != null) {
            docs.remove(documentId);
            if (docs.isEmpty()) {
                permissions.remove(username);
            }
        }
    }

    /**
     * Returns true if the given user is allowed to access the given document ID.
     */
    public synchronized boolean isAllowed(String username, String documentId) {
        Set<String> docs = permissions.get(username);
        return docs != null && docs.contains(documentId);
    }
}

