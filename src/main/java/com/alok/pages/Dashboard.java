package com.alok.pages;

import com.alok.dto.EmployeeDetailsDTO;
import com.alok.entities.Employee;
import com.alok.services.Impl.EmployeeServiceImpl;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class Dashboard {

    @Property
    private long personId;

    @Inject
    private EmployeeServiceImpl employeeServiceImpl;

    @Property
    private Employee employee;

    @InjectComponent
    private Zone detailsZone;

    @Property
    private List<EmployeeDetailsDTO> listOfEmployees;

    @Property
    private EmployeeDetailsDTO employeeDetailsDTO;

    @Inject
    private AjaxResponseRenderer ajaxResponseRenderer;

    @Inject
    private Request request;

    // The code

    // set() is public so that other pages can use it to set up this page.

    public void set(Long personId) {
        this.personId = personId;
    }

    // onActivate() is called by Tapestry to pass in the activation context from the URL.

    void onActivate(Long personId) {
        this.personId = personId;
    }

    // onPassivate() is called by Tapestry to get the activation context to put in the URL.
    // To return more than one parameter, use Long[], or List<Long>, or Object[], or List<Object>.

    Long onPassivate() {
        employee = employeeServiceImpl.getById(personId);
        return personId;
    }

    void onRefreshZone() {
        listOfEmployees = employeeServiceImpl.getAll().stream().map(emp-> new EmployeeDetailsDTO(emp.getId(),emp.getFirstName(), emp.getLastName(), emp.getAge(), emp.getAddress(), emp.getEmail())).collect(Collectors.toList());
        ajaxResponseRenderer.addRender(detailsZone);
    }

}
