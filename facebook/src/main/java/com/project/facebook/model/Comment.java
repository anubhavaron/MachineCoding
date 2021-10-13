package com.project.facebook.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Comment {
    private String timeStamp;
    private String description;
    private String commentByUserId;
}
