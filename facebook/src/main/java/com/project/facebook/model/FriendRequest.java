package com.project.facebook.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class FriendRequest {
    private String id;
    private User sender;
    private User receiver;
    @Setter
    private FriendRequestStatus friendRequestStatus;
}
