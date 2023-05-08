package com.admin.application.language.create;

import com.admin.domain.exceptions.DomainException;
import com.admin.domain.language.LanguageGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Tag("unitTest")
public class CreateLanguageUseCaseTest {

    @InjectMocks
    private CreateLanguageUseCase useCase;

    @Mock
    private LanguageGateway gateway;

    @Test
    public void givenAValidCommand_whenCallsCreateLanguage_shouldReturnLanguageId() {
        final var expectedName = "Java";
        final var expectedDescription = "Description";

        final var aCommand =
                CreateLanguageCommand.with(expectedName, expectedDescription);

        when(gateway.create(any()))
                .thenAnswer(returnsFirstArg());

        final var actualOutput = useCase.execute(aCommand);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertNotNull(actualOutput.id());

        Mockito.verify(gateway, times(1)).create(argThat(language ->
                Objects.equals(expectedName, language.getName())
                        && Objects.equals(expectedDescription, language.getDescription())
                        && Objects.nonNull(language.getId())
        ));
    }

    @Test
    public void givenAInvalidName_whenCallsCreateLanguage_thenShouldReturnDomainException() {
        final String expectedName = null;
        final var expectedDescription = "Description";

        final var aCommand =
                CreateLanguageCommand.with(expectedName, expectedDescription);

        Assertions.assertThrows(
                DomainException.class, ()-> useCase.execute(aCommand));
    }

    @Test
    public void givenAInvalidDescription_whenCallsCreateLanguage_thenShouldReturnDomainException() {
        final var expectedName = "Java";
        final String expectedDescription = null;

        final var aCommand =
                CreateLanguageCommand.with(expectedName, expectedDescription);

        Assertions.assertThrows(
                DomainException.class, ()-> useCase.execute(aCommand));
    }
}
