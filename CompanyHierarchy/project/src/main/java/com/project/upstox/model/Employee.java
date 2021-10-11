package com.project.upstox.model;


import com.project.upstox.service.EmployeeIdService;
import lombok.Getter;


public class Employee {
    @Getter
    private String name;

    @Getter
    private int id;

    public Employee(String name) {
        this.id = EmployeeIdService.getId();
        this.name = name;
    }

}













