package org.example;

import java.time.LocalDateTime;

/**
 * RealSubject in the Proxy pattern. Represents an actual document whose content
 * may or may not be protected (protection happens only when accessed via a proxy).
 */
public class RealDocument implements Document {

    private final String id;
    private final LocalDateTime creationDate;
    private final String content;

    public RealDocument(String id, LocalDateTime creationDate, String content) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id must not be null or blank");
        }
        if (creationDate == null) {
            throw new IllegalArgumentException("creationDate must not be null");
        }
        if (content == null) {
            throw new IllegalArgumentException("content must not be null");
        }
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        // No access control here: unprotected document or already-checked access.
        return content;
    }

    @Override
    public String toString() {
        return "RealDocument{" +
                "id='" + id + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}

