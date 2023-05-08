package com.admin.infrastructure.api.controller;

import com.admin.application.language.create.CreateLanguageCommand;
import com.admin.application.language.create.CreateLanguageOutput;
import com.admin.application.language.create.CreateLanguageUseCase;
import com.admin.application.language.retrieve.ListLanguagesUseCase;
import com.admin.domain.exceptions.DomainException;
import com.admin.infrastructure.api.LanguageAPI;
import com.admin.infrastructure.language.models.CreateLanguageRequest;
import com.admin.infrastructure.language.models.LanguageListResponse;
import com.admin.infrastructure.language.presenters.LanguageApiPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class LanguageController implements LanguageAPI {

    private final CreateLanguageUseCase createLanguageUseCase;

    private final ListLanguagesUseCase listLanguageUseCase;

    public LanguageController(CreateLanguageUseCase createLanguageUseCase, ListLanguagesUseCase listLanguageUseCase) {
        this.createLanguageUseCase = Objects.requireNonNull(createLanguageUseCase);;
        this.listLanguageUseCase = Objects.requireNonNull(listLanguageUseCase);;
    }

    @Override
    public ResponseEntity<?> createLanguage(final CreateLanguageRequest input) {
        final var command = CreateLanguageCommand.with(input.name(), input.description());

        CreateLanguageOutput output = null;
        try{
            output = this.createLanguageUseCase.execute(command);
        }catch (DomainException e){
            return ResponseEntity.unprocessableEntity().body(e.getErrors());
        }

        return ResponseEntity.created(URI.create("/languages" + output.id())).body(output);
    }

    @Override
    public List<LanguageListResponse> listLanguages() {
        return this.listLanguageUseCase.execute().stream().map(LanguageApiPresenter::present).toList();
    }
}
