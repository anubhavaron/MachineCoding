package com.project.facebook.service;

import com.project.facebook.dao.SearchDao;
import com.project.facebook.model.Group;
import com.project.facebook.model.Page;
import com.project.facebook.model.User;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Catalog implements SearchService {

    private SearchDao searchDao;

    public Catalog(SearchDao searchDao) {
        this.searchDao = searchDao;
    }

    @Override
    public ArrayList<User> getUsers(String name) {
        return null;
    }

    @Override
    public ArrayList<Group> getGroups(String name) {
        return null;
    }

    @Override
    public ArrayList<Page> getPages(String name) {
        return null;
    }
}
