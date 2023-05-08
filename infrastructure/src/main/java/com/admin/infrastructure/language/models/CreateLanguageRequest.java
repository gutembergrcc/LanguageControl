package com.admin.infrastructure.language.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateLanguageRequest(@JsonProperty("name") String name,
                                    @JsonProperty("description") String description) {
}
