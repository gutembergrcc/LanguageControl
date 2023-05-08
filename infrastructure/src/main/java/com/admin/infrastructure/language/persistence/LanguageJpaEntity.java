package com.admin.infrastructure.language.persistence;

import com.admin.domain.language.Language;
import com.admin.domain.language.LanguageId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Language")
@Table(name = "languages")
public class LanguageJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    public LanguageJpaEntity(){

    }
    public LanguageJpaEntity(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static LanguageJpaEntity from(final Language language){
        return new LanguageJpaEntity(language.getId().getValue(), language.getName(), language.getDescription());
    }

    public Language toAggregate() {
        return Language.with(LanguageId.from(getId()), getName(), getDescription());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
