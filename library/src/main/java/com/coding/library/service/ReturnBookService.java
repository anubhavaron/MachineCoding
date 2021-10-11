package com.coding.library.service;

import com.coding.library.dao.LibraryManagementDao;

public class ReturnBookService {

    private LibraryManagementDao libraryManagementDao;

    public ReturnBookService(LibraryManagementDao libraryManagementDao) {
        this.libraryManagementDao = libraryManagementDao;
    }
}
