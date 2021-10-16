package com.anubhav.library.model;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class BookCopy extends Book{

    private final String bookCopyId;

    public BookCopy(String bookCopyId, String bookId, String title, ArrayList<String> titles, ArrayList<String> publishers) {
        super(bookId, title, titles, publishers);
        this.bookCopyId = bookCopyId;
    }
}
