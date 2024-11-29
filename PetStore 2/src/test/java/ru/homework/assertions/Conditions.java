package ru.homework.assertions;

import ru.homework.assertions.conditions.DataCondition;
import ru.homework.assertions.conditions.ErrorMessageCondition;
import ru.homework.assertions.conditions.StatusCodeCondition;
import ru.homework.models.pet.Pet;
import ru.homework.models.store.Order;

public class Conditions {
    public static StatusCodeCondition statusCode(int code) {
        return new StatusCodeCondition(code);
    }

    public static ErrorMessageCondition errorMsg(String message) {
        return new ErrorMessageCondition(message);
    }

    public static DataCondition dataCheck(Object object) {
        return new DataCondition(object);
    }
}
