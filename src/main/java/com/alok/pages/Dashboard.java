package com.alok.pages;

import com.alok.entities.Employee;
import com.alok.services.service.EmployeeService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;


public class Dashboard {

    @Property
    private long personId;

    @Inject
    private EmployeeService employeeService;

    @Property
    private Employee employee;

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
        employee = employeeService.getById(personId);
        return personId;
    }
}
