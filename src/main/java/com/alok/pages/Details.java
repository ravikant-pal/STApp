package com.alok.pages;

import com.alok.dto.EmployeeDTO;
import com.alok.entities.Employee;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.AliasToBeanResultTransformer;


import java.util.ArrayList;
import java.util.List;

@Import(stylesheet = "context:css/style.css")
public class Details {

    @Property
    private List<EmployeeDTO> employees;

    @Property
    private EmployeeDTO employee;

    @Inject
    private Session session;

    void setupRender() {
        // Get all persons - ask business service to find them (from the database)
        employees = getListOfEmployee();
    }

    public List<EmployeeDTO> getListOfEmployee() {
        List<EmployeeDTO> employeeList = new ArrayList<>();
        session.createCriteria(Employee.class).list().forEach(i-> {
            Employee emp = (Employee) i;
            employeeList.add(new EmployeeDTO(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getAge(),emp.getAddress(),emp.getEmail()));
        });
        return employeeList;
    }
}
