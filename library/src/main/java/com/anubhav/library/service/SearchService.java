package com.anubhav.library.service;

import com.anubhav.library.dao.SearchDao;
import com.anubhav.library.model.BookCopy;

import java.util.ArrayList;

public class SearchService {

    private SearchDao searchDao;

    public SearchService(SearchDao searchDao) {
        this.searchDao = searchDao;
    }

    public ArrayList<BookCopy> getBooksById(String bookId) {
        //TODO
        return null;
    }

    public ArrayList<BookCopy> getBooksByTitle(String title) {
        //TODO
        return null;
    }

    public ArrayList<BookCopy> getBooksByAuthor(String authorName) {
        //TODO
        return null;
    }

    public ArrayList<BookCopy> getBooksByPublisher(String publisherName) {
        //TODO
        return null;
    }
}
