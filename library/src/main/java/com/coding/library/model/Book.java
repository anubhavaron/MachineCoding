package com.coding.library.model;

import lombok.Getter;

import java.util.List;

public class Book {
    @Getter
    private final String id;

    @Getter
    private final String title;

    @Getter
    private final List<String> authors;

    @Getter
    private final List<String> publishers;

    public Book(String id, String title, List<String> authors, List<String> publishers) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publishers = publishers;
    }
}
