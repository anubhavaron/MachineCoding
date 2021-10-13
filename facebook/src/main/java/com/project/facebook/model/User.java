package com.project.facebook.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter

public class User {

    @Setter
    private String name;

    @Setter
    private String id;

    @Setter
    private String email;

    @Setter
    private Education education;

    @Setter
    private WorkExperience experience;

    @Setter
    private Location location;

    @Setter
    private FriendsDetail friendsInfo;

    @Setter
    private FollowersDetail followersDetail;

    @Setter
    private Map<String, FriendRequest> friendRequestMap = new HashMap<>();

    @Setter
    private ArrayList<Group> groupArrayList = new ArrayList<>();

    @Setter
    private ArrayList<Post> postArrayList = new ArrayList<>();f


    public User(String name, String id, String email, Education education, WorkExperience experience, Location location) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.education = education;
        this.experience = experience;
        this.location = location;
    }

}
