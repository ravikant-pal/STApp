package com.alok.pages;

import com.alok.dto.EmployeeRegistrationDTO;
import com.alok.entities.Employee;
import com.alok.services.Impl.EmployeeServiceImpl;
import org.apache.tapestry5.alerts.AlertManager;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import org.slf4j.Logger;


public class Registration {
    @Inject
    private Logger logger;

    @Inject
    private AlertManager alertManager;

    @Inject
    private EmployeeServiceImpl employeeServiceImpl;

    @InjectPage
    private Login login;

    @Property
    EmployeeRegistrationDTO newEmployee;


    Object onSuccess() {
        employeeServiceImpl.save(newEmployee);
        logger.info("Registration successful!");
        alertManager.success("Registration successful, Please Login!");
        return login;
    }
}
