package com.project.facebook.dao;

import com.project.facebook.model.Group;
import com.project.facebook.model.Page;
import com.project.facebook.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class SearchDao {
    private Map<String, ArrayList<User>> nameToUserMap = new HashMap<>();
    private Map<String, ArrayList<Group>> nameToGroupMap = new HashMap<>();;
    private Map<String, ArrayList<Page>> nameToPageMap = new HashMap<>();
}
