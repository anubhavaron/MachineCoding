package com.project.facebook.service;

import com.project.facebook.dao.SearchDao;
import com.project.facebook.model.*;

import java.util.ArrayList;

public interface SearchService {
    ArrayList<User> getUsers(String name);
    ArrayList<Group> getGroups(String name);
    ArrayList<Page> getPages(String name);
}
