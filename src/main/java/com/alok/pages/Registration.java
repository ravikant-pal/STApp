package com.alok.pages;

import com.alok.entities.Employee;
import com.alok.services.service.EmployeeService;
import org.apache.tapestry5.alerts.AlertManager;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

import org.slf4j.Logger;


public class Registration {
    @Inject
    private Logger logger;

    @Inject
    private AlertManager alertManager;

    @Property
    private Employee newEmployee;

    @Inject
    private EmployeeService employeeService;

    @InjectPage
    private Login login;

    @CommitAfter
    Object onSuccess() {
        employeeService.save(newEmployee);
        logger.info("Registration successful!");
        alertManager.success("Registration successful, Please Login!");
        return login;
    }
}
