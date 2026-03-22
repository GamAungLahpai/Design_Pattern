package org.example;

import java.time.LocalDateTime;

/**
 * Protection proxy for {@link RealDocument}. Controls access to the document content
 * using {@link AccessControlService} while still exposing document metadata.
 */
public class DocumentProxy implements Document {

    private final RealDocument realDocument;
    private final AccessControlService accessControlService;

    public DocumentProxy(RealDocument realDocument) {
        if (realDocument == null) {
            throw new IllegalArgumentException("realDocument must not be null");
        }
        this.realDocument = realDocument;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public String getId() {
        return realDocument.getId();
    }

    @Override
    public LocalDateTime getCreationDate() {
        // Metadata always accessible, no access control.
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        String username = user == null ? null : user.getUsername();
        if (username == null) {
            throw new AccessDeniedException("Anonymous access is not allowed for protected document '" + getId() + "'.");
        }
        if (accessControlService.isAllowed(username, getId())) {
            return realDocument.getContent(user);
        }
        throw new AccessDeniedException(username, getId());
    }

    @Override
    public String toString() {
        return "DocumentProxy{" +
                "id='" + getId() + '\'' +
                ", creationDate=" + getCreationDate() +
                '}';
    }
}

