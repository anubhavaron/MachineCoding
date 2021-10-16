package com.anubhav.library.service;

import com.anubhav.library.dao.LibraryDao;
import com.anubhav.library.dao.SearchDao;
import com.anubhav.library.exception.NoRackSpaceException;
import com.anubhav.library.model.Book;
import com.anubhav.library.model.BookCopy;
import com.anubhav.library.util.BookPrintUtil;

import java.util.ArrayList;

public class LibraryManagementService {

    private LibraryDao libraryDao = new LibraryDao();

    private SearchDao searchDao = new SearchDao();

    private BooksManagementService booksManagementService = new BooksManagementService();

    private BorrowBookService borrowBookService = new BorrowBookService();

    private ReturnBookService returnBookService = new ReturnBookService();

    private PrintDetailService printDetailService = new PrintDetailService();

    private SearchService service = new SearchService(searchDao);


    public void createLibrary(Integer racks) {
        libraryDao.createDefaultData(racks);
    }

    public void addBookCopies(Book baseBook, ArrayList<BookCopy> bookCopiesList) throws NoRackSpaceException {
        booksManagementService.addBookCopiesToDao(baseBook, bookCopiesList, libraryDao, searchDao);
    }

    public void borrowBookCopy(BookCopy bookCopy, String userId) {
        borrowBookService.borrowBookCopy(bookCopy, userId, libraryDao, searchDao);
    }

    public void borrowBook(Book book, String userId) {
        borrowBookService.borrowBook(book, userId, libraryDao, searchDao);
    }

    public void returnBook(BookCopy bookCopy, String userId) {
        returnBookService.returnBookCopy(bookCopy, userId, libraryDao, searchDao);
    }

    public void printUserDetail(String id) {
        printDetailService.printUserDetail(id, libraryDao);
    }

    public void searchBookByPublisher(String publisher) {
        ArrayList<BookCopy> bookCopies = service.getBooksByPublisher(publisher);
        BookPrintUtil.printBookCopy(bookCopies);
    }

    public void searchBookByAuthor(String author) {
        ArrayList<BookCopy> bookCopies = service.getBooksByAuthor(author);
        BookPrintUtil.printBookCopy(bookCopies);
    }

    public void searchBookByBookId(String bookId) {
        ArrayList<BookCopy> bookCopies = service.getBooksById(bookId);
        BookPrintUtil.printBookCopy(bookCopies);
    }

    public void searchBookByTitle(String title) {
        ArrayList<BookCopy> bookCopies = service.getBooksByTitle(title);
        BookPrintUtil.printBookCopy(bookCopies);

    }
}
