package com.admin.domain.language;

import com.admin.domain.validation.Notification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LanguageTest {

    @Test
    public void givenAValidParams_whenCallNewLanguage_thenInstantiateALanguage() {
        final var expectedName = "Java";
        final var expectedDescription = "Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90, na empresa Sun Microsystems";

        final var actualLanguage = Language.newLanguage(expectedName, expectedDescription);

        Assertions.assertNotNull(actualLanguage);
        Assertions.assertNotNull(actualLanguage.getId());
        Assertions.assertEquals(expectedName, actualLanguage.getName());
        Assertions.assertEquals(expectedDescription, actualLanguage.getDescription());
    }

    @Test
    public void givenAnInvalidNullName_whenCallNewLanguageAndValidate_thenShouldReceiveError() {
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should not be null";
        final var expectedDescription = "Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90, na empresa Sun Microsystems";

        final var actualLanguage = Language.newLanguage(null, expectedDescription);

        Notification notification = Notification.create();
        actualLanguage.validate(notification);

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }

    @Test
    public void givenAnEmptyName_whenCallNewLanguageAndValidate_thenShouldReceiveError() {
        final String expectedName = " ";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should not be empty";
        final var expectedDescription = "Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90, na empresa Sun Microsystems";

        final var actualLanguage = Language.newLanguage(expectedName, expectedDescription);

        Notification notification = Notification.create();
        actualLanguage.validate(notification);

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }

    @Test
    public void givenAInvalidName_whenCallNewLanguageAndValidate_thenShouldReceiveError() {
        final String expectedName = "Te ";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' must be between 3 and 255 characters";
        final var expectedDescription = "Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90, na empresa Sun Microsystems";

        final var actualLanguage = Language.newLanguage(expectedName, expectedDescription);

        Notification notification = Notification.create();
        actualLanguage.validate(notification);

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }

    @Test
    public void givenAInvalidNameMore255Chars_whenCallNewLanguageAndValidate_thenShouldReceiveError() {
        final String expectedName = """
                xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                """;
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' must be between 3 and 255 characters";
        final var expectedDescription = "Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90, na empresa Sun Microsystems";

        final var actualLanguage = Language.newLanguage(expectedName, expectedDescription);

        Notification notification = Notification.create();
        actualLanguage.validate(notification);

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }

    @Test
    public void givenAnInvalidNullDescription_whenCallNewLanguageyAndValidate_thenShouldReceiveError() {
        final String expectedName = "Developer";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'description' should not be null";

        final var actualLanguage = Language.newLanguage(expectedName, null);

        Notification notification = Notification.create();
        actualLanguage.validate(notification);

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }

    @Test
    public void givenAnInvalidEmptyDescription_whenCallNewLanguageyAndValidate_thenShouldReceiveError() {
        final String expectedName = "Developer";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'description' should not be empty";
        final String expectedDescription = " ";


        final var actualLanguage = Language.newLanguage(expectedName, expectedDescription);

        Notification notification = Notification.create();
        actualLanguage.validate(notification);

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }

    @Test
    public void givenAnInvalidAcronymLess3_whenCallNewLanguageyAndValidate_thenShouldReceiveError() {
        final String expectedName = "Developer";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'description' must be between 3 and 255 characters";
        final String expectedDescription = "D";

        final var actualLanguage = Language.newLanguage(expectedName, expectedDescription);

        Notification notification = Notification.create();
        actualLanguage.validate(notification);

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }

    @Test
    public void givenAnInvalidAcronymMore30_whenCallNewLanguageyAndValidate_thenShouldReceiveError() {
        final String expectedName = "Developer";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'description' must be between 3 and 255 characters";
        final String expectedDescription = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

        final var actualLanguage = Language.newLanguage(expectedName, expectedDescription);

        Notification notification = Notification.create();
        actualLanguage.validate(notification);

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }
}
