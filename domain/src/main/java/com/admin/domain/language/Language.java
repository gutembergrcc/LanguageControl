package com.admin.domain.language;

import com.admin.domain.AggregateRoot;
import com.admin.domain.validation.ValidationHandler;

public class Language extends AggregateRoot<LanguageId> {

    private String name;

    private String description;

    private Language(final LanguageId id, final String name, final String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public static Language newLanguage(final String name, final String description) {
        final var id = LanguageId.unique();
        return new Language(id, name, description);
    }

    public static Language with(final LanguageId languageId, final String name, String description) {
        return new Language(languageId, name, description);
    }

    @Override
    public void validate(final ValidationHandler handler) {
        new LanguageValidator(this, handler).validate();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
