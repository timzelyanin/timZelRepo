package ru.homework.tests.pets;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.homework.assertions.Conditions;
import ru.homework.models.pet.Pet;
import ru.homework.tests.BaseTest;
import ru.homework.utils.TestDataGenerator;

import static ru.homework.assertions.Conditions.dataCheck;
import static ru.homework.assertions.Conditions.statusCode;

@Epic("Pet store")
@Feature("Pet")
@Story("Get")
@DisplayName("Получение pet")
public class GetPetTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Получение pet по id и сравнение")
    public void getPetTest() {
        Pet fullDataPet = TestDataGenerator.generateFullDataPet();
        petController.createPet(fullDataPet)
                .shouldHave(statusCode(200))
                .shouldHave(dataCheck(fullDataPet));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Попытка запроса get pet по несуществующему Id")
    public void getNotFoundPetTest() {
        petController.getPet(-1)
                .shouldHave(statusCode(404))
                .shouldHave(Conditions.errorMsg("Pet not found"));;
    }
}
