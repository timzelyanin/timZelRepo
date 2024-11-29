package ru.homework.assertions;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class AssertableResponse {

    public final ValidatableResponse response;

    /**
     * Обертка для кастомных проверок
     *
     * @param condition
     * @return
     */
    @Step
    public AssertableResponse shouldHave(Condition condition) {
        log.info("Check for: {}", condition.toString());
        condition.check(response);
        return this;
    }

    /**
     * Извлечение ответа в определенный класс
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T as(Class<T> clazz) {
        return response.extract().body().as(clazz);
    }
}
