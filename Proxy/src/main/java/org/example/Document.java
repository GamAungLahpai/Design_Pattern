package org.example;

import java.time.LocalDateTime;

/**
 * Subject interface in the Proxy pattern. Both real documents and proxies implement this.
 */
public interface Document {
    String getId();

    LocalDateTime getCreationDate();

    /**
     * Returns the content of the document for the given user. Implementations may perform
     * access control checks and throw {@link AccessDeniedException}.
     */
    String getContent(User user) throws AccessDeniedException;
}

