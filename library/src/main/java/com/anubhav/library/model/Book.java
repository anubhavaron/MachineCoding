package com.anubhav.library.model;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Book {

    private final String id;

    private final String title;

    private final ArrayList<String> authors;

    private final ArrayList<String> publishers;

    public Book(String id, String title, ArrayList<String> authors, ArrayList<String> publishers) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publishers = publishers;
    }
}
