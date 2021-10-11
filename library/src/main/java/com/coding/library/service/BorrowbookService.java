package com.coding.library.service;

import com.coding.library.dao.LibraryManagementDao;

public class BorrowbookService {
    private LibraryManagementDao libraryManagementDao;

    public BorrowbookService(LibraryManagementDao libraryManagementDao) {
        this.libraryManagementDao = libraryManagementDao;
    }
}
