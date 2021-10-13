package com.project.facebook.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class FollowersDetail {
    private ArrayList<User> followers = new ArrayList<>();
}
