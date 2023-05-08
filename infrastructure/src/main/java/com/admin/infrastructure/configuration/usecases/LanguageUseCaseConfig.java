package com.admin.infrastructure.configuration.usecases;

import com.admin.application.language.create.CreateLanguageUseCase;
import com.admin.application.language.retrieve.ListLanguagesUseCase;
import com.admin.domain.language.LanguageGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LanguageUseCaseConfig {

    private final LanguageGateway languageGateway;

    public LanguageUseCaseConfig(LanguageGateway languageGateway) {
        this.languageGateway = languageGateway;
    }

    @Bean
    public CreateLanguageUseCase createLanguageUseCase() {
        return new CreateLanguageUseCase(languageGateway);
    }

    @Bean
    public ListLanguagesUseCase listLanguageUseCase() {
        return new ListLanguagesUseCase(languageGateway);
    }
}
