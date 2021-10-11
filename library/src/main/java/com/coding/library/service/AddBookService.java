package com.coding.library.service;

import com.coding.library.dao.LibraryManagementDao;
import com.coding.library.exception.NoRackAvailableException;
import com.coding.library.model.BookCopy;
import com.coding.library.model.Rack;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AddBookService {

    private LibraryManagementDao libraryManagementDao;

    public AddBookService(LibraryManagementDao libraryManagementDao) {
        this.libraryManagementDao = libraryManagementDao;
    }

    public void addBookToLibrary(BookCopy bookCopy) throws NoRackAvailableException {
        int rackId = getAvailableRackId();
        Rack rack = libraryManagementDao.getRackIdToRackMap().get(rackId);
        libraryManagementDao.getRackToBookCopyMap().put(rack, bookCopy);
        if(Objects.nonNull(libraryManagementDao.getBookIdToCopyListMap().get(bookCopy.getId()))) {
            List<BookCopy> bookCopyList = libraryManagementDao.getBookIdToCopyListMap().get(bookCopy.getId());
            bookCopyList.add(bookCopy);
            libraryManagementDao.getBookIdToCopyListMap().put(bookCopy.getId(), bookCopyList);
        } else {
            libraryManagementDao.getBookIdToCopyListMap().put(bookCopy.getId(), Arrays.asList(bookCopy));
        }


    }

    private int getAvailableRackId() throws NoRackAvailableException{
        if(!isRackAvailable())
            throw new NoRackAvailableException();
        return  libraryManagementDao.getAvailableRacks().iterator().next();
    }

    private boolean isRackAvailable() {
        return (libraryManagementDao.getAvailableRacks().size() != 0);
    }
}
