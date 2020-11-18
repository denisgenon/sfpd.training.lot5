package io.hackages.learning.model;

public enum ProductCategory {

    CAT_FOOD("Food for Cats"),

    DOG_FOOD("Food for Dogs"),

    BIRD_FOOD("Food for Birds");

    String description;

    ProductCategory(String desc) {
        description = desc;
    }
}
