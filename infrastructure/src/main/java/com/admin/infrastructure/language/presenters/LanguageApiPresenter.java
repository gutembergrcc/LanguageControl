package com.admin.infrastructure.language.presenters;

import com.admin.application.language.retrieve.LanguageListOutput;
import com.admin.infrastructure.language.models.LanguageListResponse;

public interface LanguageApiPresenter {

    static LanguageListResponse present(final LanguageListOutput output) {
        return new LanguageListResponse(
                output.id().getValue(),
                output.name(),
                output.description()
        );
    }
}
