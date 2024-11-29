package ru.homework.assertions.conditions;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import ru.homework.assertions.Condition;

@AllArgsConstructor
public class StatusCodeCondition implements Condition {

    private final int statusCode;

    @Override
    public void check(ValidatableResponse response) {
        response.assertThat().statusCode(statusCode);
    }

    @Override
    public String toString() {
        return "Status code is " + statusCode;
    }
}
