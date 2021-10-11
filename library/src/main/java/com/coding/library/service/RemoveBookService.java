package com.coding.library.service;

import com.coding.library.dao.LibraryManagementDao;

public class RemoveBookService {

    private LibraryManagementDao libraryManagementDao;

    public RemoveBookService(LibraryManagementDao libraryManagementDao) {
        this.libraryManagementDao = libraryManagementDao;
    }
}
