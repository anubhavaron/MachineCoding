package com.coding.library.dao;

import com.coding.library.model.Book;
import com.coding.library.model.BookCopy;
import com.coding.library.model.Rack;
import com.coding.library.model.User;
import com.coding.library.service.*;
import lombok.Getter;

import java.util.*;

public class LibraryManagementDao {
    @Getter
    private Integer racks;

    @Getter
    private Set<Integer> availableRacks = new HashSet<>();

    @Getter
    private Map<Integer, Rack> rackIdToRackMap = new HashMap<>();

    @Getter
    private Map<Rack, BookCopy> rackToBookCopyMap = new HashMap<>();

    @Getter
    private Map<String, List<BookCopy> > bookIdToCopyListMap = new HashMap<>();

    @Getter
    private Map<BookCopy, Rack>  bookCopyRackMap = new HashMap<>();

    @Getter
    private Map<User, List<BookCopy> > userToBorrowedBooks = new HashMap<>();

    public LibraryManagementDao(Integer racks) {
        this.racks = racks;
        init();
    }

    private void init() {
        for(int rackNo = 1; rackNo <= racks; rackNo++) {
            Rack rack = new Rack(rackNo);
            availableRacks.add(rackNo);
            rackIdToRackMap.put(rackNo, rack);
        }
    }
}
