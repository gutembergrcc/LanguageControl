package com.admin.infrastructure.language.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<LanguageJpaEntity, String> {
}
