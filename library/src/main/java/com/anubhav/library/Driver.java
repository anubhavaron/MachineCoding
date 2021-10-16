package com.anubhav.library;

import com.anubhav.library.service.LibraryManagementService;
import com.anubhav.library.service.LibraryManagementServiceGetter;

public class Driver {

    public static void main(String[] args) {
        Integer rack = 10;
        LibraryManagementService libraryManagementService = LibraryManagementServiceGetter.get();
        libraryManagementService.createLibrary(rack);
        // Create Library Admin and Users and Use functionalities
    }
}
