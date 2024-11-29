package ru.homework.tests.pets;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.homework.models.pet.Pet;
import ru.homework.tests.BaseTest;
import ru.homework.utils.TestDataGenerator;

import static ru.homework.assertions.Conditions.statusCode;

@Epic("Pet store")
@Feature("Pet")
@Story("Post")
@DisplayName("Добавление pet")
public class AddPetTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Добавление pet с минимальным набором полей")
    public void createMinDataPet() {
        Pet minDataPet = TestDataGenerator.generateMinDataPet();
        petController.createPet(minDataPet)
                .shouldHave(statusCode(200));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Добавление pet с максимальным набором полей")
    public void createFullDataPet() {
        Pet fullDataPet = TestDataGenerator.generateFullDataPet();
        petController.createPet(fullDataPet)
                .shouldHave(statusCode(200));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Обработка некорректного тела запроса методом post")
    public void postIncorrectJson() {
        String invalidJson = "{fake}";
        petController.createPet(invalidJson)
                .shouldHave(statusCode(400));
    }
}
