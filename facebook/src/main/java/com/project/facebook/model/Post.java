package com.project.facebook.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;

@AllArgsConstructor
@Getter
public class Post {
    private Image image;
    private ArrayList<String> likedUsersId;
    private ArrayList<Comment> comments;
}
