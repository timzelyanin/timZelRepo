package ru.homework.utils;

import com.github.javafaker.Faker;
import ru.homework.models.pet.Category;
import ru.homework.models.pet.Pet;
import ru.homework.models.pet.Status;
import ru.homework.models.pet.Tag;
import ru.homework.models.store.Order;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class TestDataGenerator {
    private static final Faker faker = new Faker();

    public static Pet generateFullDataPet() {
        return Pet.builder()
                .id(getRandomInt())
                .name(faker.funnyName().name())
                .photoUrls(Arrays.asList(faker.animal().name(), faker.beer().name()))
                .category(Category.builder()
                        .id(getRandomInt())
                        .name(faker.cat().name())
                        .build())
                .tags(Arrays.asList(
                        Tag.builder()
                                .id(getRandomInt())
                                .name(faker.animal().name())
                                .build(),
                        Tag.builder()
                                .id(getRandomInt())
                                .name(faker.animal().name())
                                .build()))
                .status(Status.available)
                .build();
    }

    public static Order generateOrder(int petId) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .withZone(ZoneId.systemDefault());
        return Order.builder()
                .id(getRandomInt())
                .complete(true)
                .petId(petId)
                .quantity(1)
                .shipDate(formatter.format(Instant.now()))
                .status("placed")
                .build();
    }

    public static Pet generateMinDataPet() {
        return Pet.builder()
                .id(getRandomInt())
                .name(faker.dog().name())
                .build();
    }

    private static Integer getRandomInt() {
        return faker.random().nextInt(10000);
    }
}
