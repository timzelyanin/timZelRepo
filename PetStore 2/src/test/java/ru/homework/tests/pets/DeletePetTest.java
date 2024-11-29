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
@Story("Delete")
@DisplayName("Удаление pet")
public class DeletePetTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Удаление pet с существующим Id")
    public void deletePet() {
        Pet fullDataPet = TestDataGenerator.generateFullDataPet();
        int petId = fullDataPet.getId();

        petController.createPet(fullDataPet)
                .shouldHave(statusCode(200));

        petController.deletePet(petId)
                .shouldHave(statusCode(200));

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Попытка удаления pet по несуществующему Id")
    public void deleteNotFoundPetTest() {
        petController.deletePet(-1)
                .shouldHave(statusCode(404));
    }
}
