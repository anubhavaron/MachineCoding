package com.anubhav.library.actors;

import com.anubhav.library.exception.NoRackSpaceException;
import com.anubhav.library.model.Book;
import com.anubhav.library.model.BookCopy;
import com.anubhav.library.service.LibraryManagementService;
import com.anubhav.library.service.LibraryManagementServiceGetter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
public class LibraryAdmin {

    private LibraryManagementService libraryManagementService = LibraryManagementServiceGetter.get();

    public void addBookCopies(Book baseBook, ArrayList<BookCopy> bookCopiesList) {
        try {
            libraryManagementService.addBookCopies(baseBook, bookCopiesList);
        } catch (NoRackSpaceException e) {
            System.out.println(e.getMessage());
        }
    }

}
