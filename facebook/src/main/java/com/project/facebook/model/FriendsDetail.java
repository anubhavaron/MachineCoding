package com.project.facebook.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@NoArgsConstructor
public class FriendsDetail {
    private ArrayList<User> friendsList = new ArrayList<>();
}
