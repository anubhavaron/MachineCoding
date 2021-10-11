package com.coding.library;

import com.coding.library.dao.LibraryManagementDao;
import com.coding.library.exception.NoRackAvailableException;
import com.coding.library.model.BookCopy;
import com.coding.library.service.*;
import lombok.Getter;

import java.util.List;

public class LibraryManagerSystem {

    @Getter
    private LibraryManagementDao libraryManagementDao;

    private AddBookService addBookService;
    private BorrowbookService borrowbookService;
    private DetailPrintService detailPrintService;
    private RemoveBookService removeBookService;
    private ReturnBookService returnBookService;
    private SearchDataService searchDataService;

    public LibraryManagerSystem(int racks) {
        libraryManagementDao = new LibraryManagementDao(racks);
        addBookService = new AddBookService(libraryManagementDao);
        borrowbookService = new BorrowbookService(libraryManagementDao);
        detailPrintService = new DetailPrintService(libraryManagementDao);
        removeBookService = new RemoveBookService(libraryManagementDao);
        returnBookService = new ReturnBookService(libraryManagementDao);
        searchDataService = new SearchDataService(libraryManagementDao);
    }

    public void addBook(BookCopy bookCopy) throws NoRackAvailableException {
        addBookService.addBookToLibrary(bookCopy);
    }

    public void addBooks(List<BookCopy> bookCopyList) throws NoRackAvailableException {
        for(BookCopy bookCopy : bookCopyList) {
            this.addBook(bookCopy);
        }
    }


}
