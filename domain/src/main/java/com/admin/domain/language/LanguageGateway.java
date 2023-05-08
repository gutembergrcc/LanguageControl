package com.admin.domain.language;

import java.util.List;

public interface LanguageGateway {

    Language create(Language language);

    List<Language> findAll();
}
