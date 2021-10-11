package com.project.upstox.service;

public class EmployeeIdService {

    private static int currentId = 0;

    public static int getId() {
        currentId++;
        return currentId;
    }

}
