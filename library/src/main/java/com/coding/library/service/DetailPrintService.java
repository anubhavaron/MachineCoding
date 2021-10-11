package com.coding.library.service;

import com.coding.library.dao.LibraryManagementDao;

public class DetailPrintService {

    private LibraryManagementDao libraryManagementDao;

    public DetailPrintService(LibraryManagementDao libraryManagementDao) {
        this.libraryManagementDao = libraryManagementDao;
    }
}
