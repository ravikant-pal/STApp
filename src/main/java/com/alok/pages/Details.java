package com.alok.pages;

import com.alok.dto.EmployeeDTO;
import com.alok.entities.Employee;
import com.alok.services.service.EmployeeService;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;



import java.util.ArrayList;
import java.util.List;

@Import(stylesheet = "context:css/style.css")
public class Details {

    @Property
    private List<EmployeeDTO> employees;

    @Property
    private EmployeeDTO employee;

    @Inject
    private EmployeeService employeeService;

    void setupRender() {
        // Get all persons - ask business service to find them (from the database)
        employees =  getListOfEmployee();
    }

    public List<EmployeeDTO> getListOfEmployee() {
        List<EmployeeDTO> employeeList = new ArrayList<>();
        employeeService.getAll().forEach(i-> {
            employeeList.add(new EmployeeDTO(((Employee) i).getId(), ((Employee) i).getFirstName(), ((Employee) i).getLastName(), ((Employee) i).getAge(), ((Employee) i).getAddress(), ((Employee) i).getEmail()));
        });
        return employeeList;
    }
}
