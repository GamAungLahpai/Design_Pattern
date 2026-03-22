package org.example;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Library that stores both unprotected real documents and protected proxies.
 */
public class Library {

    private final Map<String, Document> documents = new HashMap<>();

    /**
     * Adds an unprotected document directly to the library.
     */
    public void addUnprotectedDocument(RealDocument document) {
        if (document == null) {
            throw new IllegalArgumentException("document must not be null");
        }
        String id = document.getId();
        if (documents.containsKey(id)) {
            throw new IllegalArgumentException("Document with id '" + id + "' already exists in library");
        }
        documents.put(id, document);
    }

    /**
     * Factory method to create and register a protected document in the library.
     * Only the proxy is stored and returned; the real document remains hidden
     * behind the proxy.
     */
    public Document createProtectedDocument(String id, LocalDateTime creationDate, String content) {
        RealDocument realDocument = new RealDocument(id, creationDate, content);
        DocumentProxy proxy = new DocumentProxy(realDocument);
        if (documents.containsKey(id)) {
            throw new IllegalArgumentException("Document with id '" + id + "' already exists in library");
        }
        documents.put(id, proxy);
        return proxy;
    }

    /**
     * Returns the document (real or proxy) with the given id, or null if not found.
     */
    public Document getDocument(String id) {
        return documents.get(id);
    }

    /**
     * Returns an unmodifiable view of all documents stored in this library.
     */
    public Collection<Document> getAllDocuments() {
        return Collections.unmodifiableCollection(documents.values());
    }
}

