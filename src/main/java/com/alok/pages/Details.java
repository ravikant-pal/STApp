package com.alok.pages;

import com.alok.dto.EmployeeDetailsDTO;
import com.alok.entities.Employee;
import com.alok.services.Impl.EmployeeServiceImpl;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;



import java.util.ArrayList;
import java.util.List;

@Import(stylesheet = "context:css/style.css")
public class Details {

    @Property
    private List<EmployeeDetailsDTO> employees;

    @Property
    private EmployeeDetailsDTO employee;

    @Inject
    private EmployeeServiceImpl employeeServiceImpl;

    void setupRender() {
        // Get all persons - ask business service to find them (from the database)
        employees =  getListOfEmployee();
    }

    public List<EmployeeDetailsDTO> getListOfEmployee() {
        List<EmployeeDetailsDTO> employeeList = new ArrayList<>();
        employeeServiceImpl.getAll().forEach(i-> {
            employeeList.add(new EmployeeDetailsDTO(((Employee) i).getId(), ((Employee) i).getFirstName(), ((Employee) i).getLastName(), ((Employee) i).getAge(), ((Employee) i).getAddress(), ((Employee) i).getEmail()));
        });
        return employeeList;
    }
}
