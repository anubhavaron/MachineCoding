package com.project.upstox.dao;

import com.project.upstox.model.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganisationDao {
    @Getter
    @Setter
    private Map<Employee, List<Employee>> employeeToRepoteeListMap = new HashMap<>();

    @Getter
    @Setter
    private List<Employee> employeeList = new ArrayList<>();

    @Getter
    @Setter
    private Map<Employee, Employee> employeeToManagerMap = new HashMap<>();


}
