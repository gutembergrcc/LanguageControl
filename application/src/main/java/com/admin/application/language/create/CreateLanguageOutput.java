package com.admin.application.language.create;

import com.admin.domain.language.Language;

public record CreateLanguageOutput(String id) {
    public static CreateLanguageOutput from(final Language language) {
        return new CreateLanguageOutput(language.getId().getValue());
    }
}
