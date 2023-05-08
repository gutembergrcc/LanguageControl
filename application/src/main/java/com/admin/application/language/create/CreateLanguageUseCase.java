package com.admin.application.language.create;

import com.admin.application.UseCase;
import com.admin.domain.exceptions.DomainException;
import com.admin.domain.language.Language;
import com.admin.domain.language.LanguageGateway;
import com.admin.domain.validation.Notification;

import java.util.Objects;

public class CreateLanguageUseCase extends UseCase<CreateLanguageCommand, CreateLanguageOutput> {

    private final LanguageGateway languageGateway;

    public CreateLanguageUseCase(final LanguageGateway languageGateway) {
        this.languageGateway = Objects.requireNonNull(languageGateway);
    }

    @Override
    public CreateLanguageOutput execute(CreateLanguageCommand command) {
        final var name = command.name();
        final var description = command.description();

        final var language = Language.newLanguage(name, description);

        final var notification = Notification.create();
        language.validate(notification);
        if(notification.hasError()){
            throw DomainException.with(notification.getErrors());
        }

        var languageCreated = this.languageGateway.create(language);
        return CreateLanguageOutput.from(languageCreated);
    }
}
