package com.project.facebook.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@AllArgsConstructor
@Setter
@Getter
public class Page {
    private String name;
    private String admin;
    private ArrayList<Post> arrayList;
    private ArrayList<String> userId;
}
