package com.admin.application.language.create;

public record CreateLanguageCommand(String name, String description) {
    public static CreateLanguageCommand with(final String name, final String description){
        return new CreateLanguageCommand(name, description);
    }
}
