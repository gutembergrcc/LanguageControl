package com.admin.infrastructure.language.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LanguageListResponse(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description) {
}
