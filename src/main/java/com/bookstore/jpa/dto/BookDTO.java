package com.bookstore.jpa.dto;

import java.util.Set;
import java.util.UUID;

public record BookDTO(
        String title,
        UUID publisherId,
        Set<UUID> authorIds,
        String reviewComment
) {
}
