package com.project.facebook.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
public class Group {
    private String name;
    private User admin;
    private ArrayList<User> membersList = new ArrayList<>();
    private ArrayList<Post> arrayList = new ArrayList<>();
}
