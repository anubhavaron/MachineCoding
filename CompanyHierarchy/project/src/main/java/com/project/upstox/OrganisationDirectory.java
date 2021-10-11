package com.project.upstox;

import com.project.upstox.dao.OrganisationDao;
import com.project.upstox.exception.CyclicHierarchyException;
import com.project.upstox.exception.TwoMangerSameEmployeeException;
import com.project.upstox.model.Employee;
import com.project.upstox.util.OrganisationDaoUtil;
import lombok.Getter;

public class OrganisationDirectory {
    @Getter
    private OrganisationDao organisationDao = new OrganisationDao();

    public void addEmployeeHierarchy(Employee manager, Employee employee) throws TwoMangerSameEmployeeException, CyclicHierarchyException{
        OrganisationDaoUtil.addEmployeeToManager(manager, employee, this.organisationDao);
    }

    public void addManager(Employee manager) {
        OrganisationDaoUtil.addManagerToOrganisation(manager, this.organisationDao);
    }

    public void printHierarchy()  {
        OrganisationDaoUtil.printHierarchy(organisationDao);

    }

}
