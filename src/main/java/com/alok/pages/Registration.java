package com.alok.pages;

import com.alok.entities.Employee;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.slf4j.Logger;

public class Registration {
    @Inject
    private Logger logger;

    @Inject
    private AlertManager alertManager;

    @Property
    private Employee newEmployee;

    @Inject
    private Session session;

    @InjectPage
    private Login login;

    @CommitAfter
    Object onSuccess() {
        session.persist(newEmployee);
        logger.info("Registration successful!");
        alertManager.success("Registration successful, Please Login!");
        return login;
    }
}
