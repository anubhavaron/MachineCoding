package com.anubhav.library.util;

import com.anubhav.library.dao.LibraryDao;
import com.anubhav.library.dao.SearchDao;
import com.anubhav.library.model.Book;
import com.anubhav.library.model.BookCopy;

import java.util.ArrayList;

public class DaoUtil {

    public static Integer getAvailableRackNumber(LibraryDao libraryDao) {
        return libraryDao.getAvailableRacks().iterator().next();
    }

    public static void addBookCopyToLibraryDao(LibraryDao libraryDao, BookCopy bookCopy, Integer rackNo) {
        libraryDao.putBookIdToRackNumber(bookCopy.getBookCopyId(), rackNo);
        libraryDao.getBookCopyIdToRackMap().put(bookCopy.getBookCopyId(), rackNo);
    }

    public static void addBookCopyToSearchDao(Book baseBook, ArrayList<BookCopy> bookCopiesList, SearchDao searchDao) {
        searchDao.addBooks(baseBook, bookCopiesList);
        String title = baseBook.getTitle();
        ArrayList<String> authors = baseBook.getAuthors();
        ArrayList<String> publishers = baseBook.getPublishers();
        searchDao.addTitlesWithBookId(title, baseBook.getId());
        searchDao.addPublisherToBookId(publishers, baseBook.getId());
        searchDao.addAuthorToBookId(authors, baseBook.getId());
    }
}
