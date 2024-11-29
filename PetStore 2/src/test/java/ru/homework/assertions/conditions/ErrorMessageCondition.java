package ru.homework.assertions.conditions;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import ru.homework.assertions.Condition;
import ru.homework.models.ApiResponse;

@AllArgsConstructor
public class ErrorMessageCondition implements Condition {

    private final String errorMessage;

    @Override
    public void check(ValidatableResponse response) {
        ApiResponse message = response.extract().as(ApiResponse.class);
        Assertions.assertEquals(errorMessage, message.getMessage());
    }

    @Override
    public String toString() {
        return "Error message is " + errorMessage;
    }
}
