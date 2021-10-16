package com.anubhav.library.service;

import com.anubhav.library.dao.LibraryDao;
import com.anubhav.library.dao.SearchDao;
import com.anubhav.library.exception.NoRackSpaceException;
import com.anubhav.library.model.Book;
import com.anubhav.library.model.BookCopy;
import com.anubhav.library.util.DaoUtil;

import java.util.ArrayList;

public class BooksManagementService {

    public void addBookCopiesToDao(Book baseBook, ArrayList<BookCopy> bookCopiesList, LibraryDao libraryDao,
                                   SearchDao searchDao) throws NoRackSpaceException {
        checkRacksAvailable(bookCopiesList, libraryDao);
        for(BookCopy bookCopy : bookCopiesList) {
            Integer rackNo = DaoUtil.getAvailableRackNumber(libraryDao);
            DaoUtil.addBookCopyToLibraryDao(libraryDao, bookCopy, rackNo);
            libraryDao.getAvailableRacks().remove(rackNo);
        }
        DaoUtil.addBookCopyToSearchDao(baseBook, bookCopiesList,searchDao);
    }

    private void checkRacksAvailable(ArrayList bookCopiesList, LibraryDao libraryDao) throws NoRackSpaceException {
        if(libraryDao.getAvailableRacks().size() < bookCopiesList.size()) {
            throw new NoRackSpaceException();
        }
    }

}
