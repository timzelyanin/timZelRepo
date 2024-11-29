package ru.homework.assertions.conditions;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import ru.homework.assertions.Condition;

@AllArgsConstructor
public class DataCondition implements Condition {
    private final Object expectedData;

    @Override
    public void check(ValidatableResponse response) {
        Object actualData = response.extract().as(expectedData.getClass());
        Assertions.assertEquals(expectedData, actualData);
    }

    @Override
    public String toString() {
        return "Expected data is " + expectedData;
    }
}
