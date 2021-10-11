package com.coding.library.service;

import com.coding.library.dao.LibraryManagementDao;

public class SearchDataService {

    private LibraryManagementDao libraryManagementDao;

    public SearchDataService(LibraryManagementDao libraryManagementDao) {
        this.libraryManagementDao = libraryManagementDao;
    }
}
