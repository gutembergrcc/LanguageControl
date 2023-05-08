package com.admin.domain.language;

import com.admin.domain.Identifier;
import com.admin.domain.utils.IdUtils;

import java.util.Objects;

public class LanguageId extends Identifier {

    private final String value;

    private LanguageId(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static LanguageId unique() {
        return LanguageId.from(IdUtils.uuid());
    }

    public static LanguageId from(final String id) {
        return new LanguageId(id);
    }

    @Override
    public String getValue() {
        return value;
    }
}
