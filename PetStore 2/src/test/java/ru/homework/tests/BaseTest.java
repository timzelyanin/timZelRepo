package ru.homework.tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.BeforeAll;
import ru.homework.service.PetController;
import ru.homework.service.StoreController;

public class BaseTest {
    protected final PetController petController = new PetController();
    protected final StoreController storeController = new StoreController();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured());
    }
}
