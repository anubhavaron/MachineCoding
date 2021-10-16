package com.anubhav.library.actors;

import com.anubhav.library.model.Book;
import com.anubhav.library.model.BookCopy;
import com.anubhav.library.service.LibraryManagementService;
import com.anubhav.library.service.LibraryManagementServiceGetter;
import lombok.Getter;

@Getter
public class User {

    private final String id;

    private final String name;


    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void borrowBook(BookCopy bookCopy) {
        LibraryManagementService libraryManagementService = LibraryManagementServiceGetter.get();
        libraryManagementService.borrowBookCopy(bookCopy, id);

    }

    public void borrowBook(Book book) {
        LibraryManagementService libraryManagementService = LibraryManagementServiceGetter.get();
        libraryManagementService.borrowBook(book, id);
    }

    public void returnBook(BookCopy bookCopy) {
        LibraryManagementService libraryManagementService = LibraryManagementServiceGetter.get();
        libraryManagementService.returnBook(bookCopy, id);
    }

    public void printDetails() {
        LibraryManagementService libraryManagementService = LibraryManagementServiceGetter.get();
        libraryManagementService.printUserDetail(id);
    }

    public void searchBookByTitle(String title) {
        LibraryManagementService libraryManagementService = LibraryManagementServiceGetter.get();
        libraryManagementService.searchBookByTitle(title);
    }

    public void searchBookByBookId(String bookId) {
        LibraryManagementService libraryManagementService = LibraryManagementServiceGetter.get();
        libraryManagementService.searchBookByBookId(bookId);
    }

    public void searchBookByAuthor(String author) {
        LibraryManagementService libraryManagementService = LibraryManagementServiceGetter.get();
        libraryManagementService.searchBookByAuthor(author);
    }

    public void searchBookByPublisher(String publisher) {
        LibraryManagementService libraryManagementService = LibraryManagementServiceGetter.get();
        libraryManagementService.searchBookByPublisher(publisher);
    }
}
