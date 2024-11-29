package ru.homework.tests.store;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.homework.models.pet.Pet;
import ru.homework.models.store.Order;
import ru.homework.tests.BaseTest;
import ru.homework.utils.TestDataGenerator;

import static ru.homework.assertions.Conditions.dataCheck;
import static ru.homework.assertions.Conditions.statusCode;

@Epic("Pet store")
@Feature("order")
@DisplayName("Создание order")
public class OrderTests extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Создание order с валидными данными")
    public void createOrderTest() {
        Pet generated = TestDataGenerator.generateFullDataPet();
        Order order = TestDataGenerator.generateOrder(generated.getId());

        storeController.createOrder(order)
                .shouldHave(statusCode(200))
                .shouldHave(dataCheck(order));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Удаление order")
    public void deleteOrderTest() {
        Order order = TestDataGenerator.generateOrder(234);
        storeController.createOrder(order);

        storeController.deleteOrder(order.getId())
                .shouldHave(statusCode(200));

        storeController.getOrder(order.getId())
                .shouldHave(statusCode(404));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Поиск order")
    public void findOrderTest(){
        Order order = TestDataGenerator.generateOrder(234);
        storeController.createOrder(order);

        storeController.getOrder(order.getId())
                .shouldHave(statusCode(200));
    }
}
