package com.alok.pages;

import com.alok.entities.Employee;
import com.alok.services.Impl.EmployeeServiceImpl;
import com.alok.services.Impl.ValidateEmployeeServiceImpl;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextArea;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;


@Import(library = {"context:jquery/age-validation.js"})
public class EditEmployee {
    @Inject
    private Logger logger;

    @Inject
    private AlertManager alertManager;

    @Property
    private long personId;

    @Property
    private Employee employee;

    @InjectComponent
    private Form edit;

    @InjectComponent("firstName")
    private TextField firstNameField;

    @InjectComponent("lastName")
    private TextField lastNameField;

    @InjectComponent("email")
    private TextField emailField;

    @InjectComponent("password")
    private PasswordField passwordField;

    @InjectComponent("image")
    private TextField imageField;

    @InjectComponent("age")
    private TextField ageField;

    @InjectComponent("address")
    private TextArea addressField;

    @InjectPage
    private SingleEmployee singleEmployee;

    @Inject
    private ValidateEmployeeServiceImpl validateEmployeeServiceImpl;

    @Inject
    private EmployeeServiceImpl employeeServiceImpl;

    public void set(Long personId) {
        this.personId = personId;
    }

    void onActivate(Long personId) {
        this.personId = personId;
        employee = employeeServiceImpl.getById(personId);
    }

    Long onPassivate() {
        return personId;
    }

    void onValidateFromEdit() {
        if(employee.getAge()<0 || employee.getAge()>120) {
            edit.recordError(ageField, " Invalid! ");
        }
    }

    Object onSuccessFromEdit() {
        employeeServiceImpl.update(employee);
        logger.info("Updated successful!");
        alertManager.success("Updated your info successfully!");
        singleEmployee.set(personId);
        return singleEmployee;
    }

    void onFailureFromEdit() {
        logger.warn("Update error!");
        alertManager.error("I'm sorry but I can't Update!");
    }

}
