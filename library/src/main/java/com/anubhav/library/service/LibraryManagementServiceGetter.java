package com.anubhav.library.service;

public class LibraryManagementServiceGetter {

    private static LibraryManagementService libraryManagementService;

    public static LibraryManagementService get() {
        if(libraryManagementService == null) {
            libraryManagementService = new LibraryManagementService();
        }
        return libraryManagementService;
    }
}
