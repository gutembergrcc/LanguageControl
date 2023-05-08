package com.admin.application.language.retrieve;

import com.admin.application.language.create.CreateLanguageUseCase;
import com.admin.domain.language.Language;
import com.admin.domain.language.LanguageGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Tag("unitTest")
public class ListLanguagesUserCaseTest {

    @InjectMocks
    private ListLanguagesUseCase useCase;

    @Mock
    private LanguageGateway gateway;

    @Test
    public void givenListUseCase_whenCallsListLanguage_shouldReturnLanguagesList() {
        final var languages = List.of(
                Language.newLanguage("Java", "Description Java"),
                Language.newLanguage("Golang", "Description GO")
        );

        when(gateway.findAll()).thenReturn(languages);

        final var actualResult = useCase.execute();

        final var expectedItemsCount = 2;
        Assertions.assertEquals(expectedItemsCount, actualResult.size());

        final var expectedResult = languages.stream().map(LanguageListOutput::from).toList();
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
