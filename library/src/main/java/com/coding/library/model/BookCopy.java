package com.coding.library.model;

import lombok.Getter;

import java.util.List;

public class BookCopy extends Book{
    @Getter
    private final String copyId;

    public BookCopy(String id, String title, List<String> authors, List<String> publishers, String copyId) {
        super(id, title, authors, publishers);
        this.copyId = copyId;
    }
}
