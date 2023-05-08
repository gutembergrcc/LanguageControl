package com.admin.infrastructure.language;

import com.admin.domain.language.Language;
import com.admin.domain.language.LanguageGateway;
import com.admin.infrastructure.language.persistence.LanguageJpaEntity;
import com.admin.infrastructure.language.persistence.LanguageRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LanguageMySQLGateway implements LanguageGateway {

    private final LanguageRepository repository;

    public LanguageMySQLGateway(final LanguageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Language create(Language language) {
        return repository.save(LanguageJpaEntity.from(language)).toAggregate();
    }

    @Override
    public List<Language> findAll() {
        return repository.findAll().stream().map(LanguageJpaEntity::toAggregate).toList();
    }
}
