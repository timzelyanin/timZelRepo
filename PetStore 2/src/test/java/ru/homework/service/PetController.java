package ru.homework.service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import ru.homework.assertions.AssertableResponse;

import static io.restassured.RestAssured.given;

public class PetController {

    private final RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBasePath("/v2/pet/")
            .addHeader("api_key", "12345")
            .build();


    public AssertableResponse getPet(int petId) {
        return new AssertableResponse(
                given(requestSpecification)
                        .get(String.valueOf(petId))
                        .then()
        );
    }

    public AssertableResponse createPet(Object pet) {
        return new AssertableResponse(
                given(requestSpecification)
                        .body(pet)
                        .post()
                        .then()
                );
    }

    public AssertableResponse updatePet(Object pet) {
        return new AssertableResponse(
                given(requestSpecification)
                        .body(pet)
                        .put()
                        .then()
        );
    }

    public AssertableResponse deletePet(int petId) {
        return new AssertableResponse(
                given(requestSpecification)
                        .delete(String.valueOf(petId))
                        .then()
        );
    }
}
