package ru.homework.tests.pets;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.homework.models.pet.Pet;
import ru.homework.tests.BaseTest;
import ru.homework.utils.TestDataGenerator;

import static ru.homework.assertions.Conditions.dataCheck;
import static ru.homework.assertions.Conditions.statusCode;

@Epic("Pet store")
@Feature("Pet")
@Story("Put")
@DisplayName("Обновление pet")
public class UpdatePetTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Обновление данных pet")
    public void updateFullDataPet() {
        Pet fullDataPet = TestDataGenerator.generateFullDataPet();
        Pet modifiedPet = fullDataPet.toBuilder().name("SayMyName").build();

        petController.createPet(fullDataPet)
                .shouldHave(statusCode(200));

        petController.updatePet(modifiedPet)
                .shouldHave(statusCode(200))
                .shouldHave(dataCheck(modifiedPet));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Создание нового pet методом put")
    public void putNewPet() {
        Pet fullDataPet = TestDataGenerator.generateFullDataPet();
        petController.updatePet(fullDataPet)
                .shouldHave(statusCode(200))
                .shouldHave(dataCheck(fullDataPet));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Обработка некорректного тела запроса методом put")
    public void putIncorrectJson() {
        petController.updatePet("fake")
                        .shouldHave(statusCode(400));
    }
}
