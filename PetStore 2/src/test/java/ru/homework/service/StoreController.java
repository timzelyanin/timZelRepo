package ru.homework.service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import ru.homework.assertions.AssertableResponse;

import static io.restassured.RestAssured.given;

public class StoreController {

    private final RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBasePath("/v2/store")
            .addHeader("api_key", "12345")
            .build();

    public AssertableResponse getOrder(int orderId) {
        return new AssertableResponse(
                given(requestSpecification)
                        .pathParam("orderId", orderId)
                        .get("/order/{orderId}")
                        .then()
        );
    }

    public AssertableResponse deleteOrder(int orderId) {
        return new AssertableResponse(
                given(requestSpecification)
                        .pathParam("orderId", orderId)
                        .delete("/order/{orderId}")
                        .then()
        );
    }

    public AssertableResponse createOrder(Object order) {
        return new AssertableResponse(
                given(requestSpecification)
                        .body(order)
                        .post("/order")
                        .then().log().all()
        );
    }
}
