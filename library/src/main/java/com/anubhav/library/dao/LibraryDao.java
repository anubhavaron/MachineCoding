package com.anubhav.library.dao;

import com.anubhav.library.model.BookCopy;
import com.anubhav.library.model.Rack;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class LibraryDao {

    private int racks;

    private Map<Integer, Rack> rackNumberToRackMap = new HashMap<>();

    private Map<String, Set<Integer>> bookIdToRackNumber = new HashMap<>();

    private Map<String, Integer> bookCopyIdToRackMap = new HashMap<>();

    private Set<Integer> availableRacks = new HashSet<>();


    private Map<String, ArrayList<BookCopy> > userIdToBorrowedBook = new HashMap<>();

    public void createDefaultData(Integer racks) {
        this.racks = racks;
        for(int i = 1; i<= racks; i++) {
            Rack rack = new Rack(i);
            rackNumberToRackMap.put(i, rack);
            availableRacks.add(i);
        }
    }

    public void putBookIdToRackNumber(String bookId, Integer rackNumber) {
        if(Objects.nonNull(bookIdToRackNumber.get(bookId))) {
            bookIdToRackNumber.get(bookId).add(rackNumber);
        } else {
            bookIdToRackNumber.put(bookId, new HashSet<>(rackNumber));
        }
    }
}
