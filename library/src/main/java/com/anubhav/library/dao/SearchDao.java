package com.anubhav.library.dao;

import com.anubhav.library.model.Book;
import com.anubhav.library.model.BookCopy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class SearchDao {

    private Map<String, ArrayList<BookCopy>> bookIdToBooksMap = new HashMap<>();

    private Map<String, String> titleToBookIdMap = new HashMap<>();

    private Map<String, ArrayList<String>> authorToBookIdsMap = new HashMap<>();

    private Map<String, ArrayList<String>> publisherToBookIdsMap = new HashMap<>();


    public void addBooks(Book baseBook, ArrayList<BookCopy> bookCopies) {
        if(Objects.nonNull(bookIdToBooksMap.get(baseBook))) {
            bookIdToBooksMap.get(baseBook.getId()).addAll(bookCopies);
        } else {
            bookIdToBooksMap.put(baseBook.getId(), bookCopies);
        }
    }

    public void addTitlesWithBookId(String title, String id) {
        titleToBookIdMap.put(title, id);
    }

    public void addPublisherToBookId(ArrayList<String> publishers, String id) {
        for(String publisher : publishers) {
            if(Objects.nonNull(publisherToBookIdsMap.get(publisher))) {
                publisherToBookIdsMap.get(publisher).add(id);
            } else {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(id);
                publisherToBookIdsMap.put(publisher,arrayList);
            }
        }
    }

    public void addAuthorToBookId(ArrayList<String> authors, String id) {
        for(String author : authors) {
            if(Objects.nonNull(publisherToBookIdsMap.get(author))) {
                publisherToBookIdsMap.get(author).add(id);
            } else {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(id);
                publisherToBookIdsMap.put(author,arrayList);
            }
        }
    }
}
