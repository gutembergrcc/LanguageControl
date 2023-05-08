package com.admin.application.language.retrieve;

import com.admin.application.NullaryUseCase;
import com.admin.application.UseCase;
import com.admin.application.language.create.CreateLanguageCommand;
import com.admin.application.language.create.CreateLanguageOutput;
import com.admin.domain.language.LanguageGateway;

import java.util.List;

public class ListLanguagesUseCase extends NullaryUseCase<List<LanguageListOutput>> {
    private final LanguageGateway languageGateway;

    public ListLanguagesUseCase(final LanguageGateway languageGateway) {
        this.languageGateway = languageGateway;
    }

    @Override
    public List<LanguageListOutput> execute() {
        return this.languageGateway.findAll().stream().map(LanguageListOutput::from).toList();
    }
}
