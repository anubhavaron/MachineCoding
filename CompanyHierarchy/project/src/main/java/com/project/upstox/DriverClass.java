package com.project.upstox;

import com.project.upstox.model.Employee;

public class DriverClass {

    public static void main(String[] args) {
        OrganisationDirectory organisationDirectory = new OrganisationDirectory();
        Employee employee1 = new Employee("A");
        Employee employee2 = new Employee("B");
        Employee employee3 = new Employee("C");
        Employee employee4 = new Employee("D");
        Employee employee5 = new Employee("K");
        Employee employee6 = new Employee("I");
        Employee employee7 = new Employee("J");
        Employee employee8 = new Employee("L");
        Employee employee9 = new Employee("G");
        Employee employee10 = new Employee("E");
        try {
            organisationDirectory.addManager(employee1);
            organisationDirectory.addEmployeeHierarchy(employee1, employee2);
            organisationDirectory.addEmployeeHierarchy(employee1, employee3);
            organisationDirectory.addEmployeeHierarchy(employee1, employee4);
            organisationDirectory.addManager(employee5);
            organisationDirectory.addEmployeeHierarchy(employee5, employee6);
            organisationDirectory.addEmployeeHierarchy(employee5, employee7);
            organisationDirectory.addManager(employee8);
            organisationDirectory.addEmployeeHierarchy(employee8, employee9);
            organisationDirectory.addEmployeeHierarchy(employee8, employee1);
            organisationDirectory.addEmployeeHierarchy(employee8, employee10);
            organisationDirectory.printHierarchy();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
