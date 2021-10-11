package com.project.upstox.util;

import com.project.upstox.dao.OrganisationDao;
import com.project.upstox.exception.CyclicHierarchyException;
import com.project.upstox.exception.TwoMangerSameEmployeeException;
import com.project.upstox.model.Employee;

import java.util.*;

public class OrganisationDaoUtil {

    public static void addManagerToOrganisation(Employee employee, OrganisationDao organisationDao) {
        organisationDao.getEmployeeList().add(employee);
        organisationDao.getEmployeeToRepoteeListMap().put(employee, new ArrayList<>());
    }

    public static void addEmployeeToManager(Employee manager, Employee employee, OrganisationDao organisationDao)
            throws TwoMangerSameEmployeeException, CyclicHierarchyException {
        organisationDao.getEmployeeList().add(employee);
        organisationDao.getEmployeeToRepoteeListMap().get(manager).add(employee);
        if(Objects.nonNull(organisationDao.getEmployeeToManagerMap().get(employee))) {
            throw new TwoMangerSameEmployeeException();
        }
        organisationDao.getEmployeeToManagerMap().put(employee, manager);
       if(isCyclicDirectory(organisationDao)) {
           throw new CyclicHierarchyException();
       }
    }

    private static boolean isCyclicDirectory(OrganisationDao organisationDao) {
        boolean cyclePresent = false;
        List<Employee> employeeList = organisationDao.getEmployeeList();
        Map<Employee, Boolean> visitedDFSEmployee = new HashMap<>();
        for(Employee employee : employeeList) {
            visitedDFSEmployee.put(employee, false);
        }
        Map<Employee, Boolean> visitedEmployee = new HashMap<>();
        for(Employee employee : employeeList) {
            visitedEmployee.put(employee, false);
        }

        for(Employee employee : employeeList) {
            if(!visitedEmployee.get(employee)) {
                if(isCycleByEmployee(visitedDFSEmployee, visitedEmployee, employee, organisationDao.getEmployeeToRepoteeListMap()))
                    return !cyclePresent;
            }
        }

        return cyclePresent;
    }

    private static boolean isCycleByEmployee(Map<Employee, Boolean> visitedDFSEmployee, Map<Employee, Boolean> visitedEmployee,
                                             Employee employee, Map<Employee, List<Employee>> employeeToReporteeListMap) {
        if(visitedEmployee.get(employee))
            return false;
        if(visitedDFSEmployee.get(employee))
            return true;
        visitedDFSEmployee.put(employee, true);
        List<Employee> repoteeList = employeeToReporteeListMap.get(employee);
        if(Objects.nonNull(repoteeList)) {
          for(Employee repotee : repoteeList) {
              if(isCycleByEmployee(visitedDFSEmployee, visitedEmployee, repotee, employeeToReporteeListMap))
                   return true;
           }
        }
        visitedDFSEmployee.put(employee, false);
        visitedEmployee.put(employee, true);
        return false;
    }

    /*
        During printing, it is always a valid hierarchy
     */
    public static void printHierarchy(OrganisationDao organisationDao) {
        Map<Employee, List<Employee>> employeeListMap = organisationDao.getEmployeeToRepoteeListMap();
        for(Map.Entry<Employee, List<Employee>> employeeListEntry : employeeListMap.entrySet()) {
            System.out.println("##########################" );
            System.out.println("Manager : " + employeeListEntry.getKey().getName());
            System.out.println("REPORTEES : " );
            for(Employee reportee : employeeListEntry.getValue()) {
                System.out.println(reportee.getName());
            }
        }
    }
}









































