package com.admin.application.language.retrieve;

import com.admin.domain.language.Language;
import com.admin.domain.language.LanguageId;

public record LanguageListOutput(LanguageId id, String name, String description) {

    public static LanguageListOutput from(final Language language) {
        return new LanguageListOutput(
                language.getId(),
                language.getName(),
                language.getDescription()
        );
    }
}
