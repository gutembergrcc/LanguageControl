package com.admin.domain.language;

import com.admin.domain.validation.Error;
import com.admin.domain.validation.ValidationHandler;
import com.admin.domain.validation.Validator;

public class LanguageValidator extends Validator {

    public static final int NAME_MAX_LENGTH = 255;
    public static final int NAME_MIN_LENGTH = 3;
    private final Language language;

    public LanguageValidator(final Language language, final ValidationHandler handler) {
        super(handler);
        this.language = language;
    }

    @Override
    public void validate() {
        checkNameConstraints();
        checkDescriptionConstraints();
    }

    private void checkNameConstraints() {
        String name = this.language.getName();
        checkConstraints("name", name);
    }

    private void checkDescriptionConstraints() {
        String description = this.language.getDescription();
        checkConstraints("description", description);
    }
    private void checkConstraints(String fieldName, String value) {


        if (value == null) {
            this.validationHandler().append(new Error("'"+ fieldName +"' should not be null"));
            return;
        }

        if (value.isBlank()) {
            this.validationHandler().append(new Error("'"+ fieldName +"' should not be empty"));
            return;
        }

        final int length = value.trim().length();
        if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH) {
            this.validationHandler().append(new Error("'"+ fieldName +"' must be between 3 and 255 characters"));
        }
    }
}
