package com.alok.pages;

import com.alok.services.Impl.EmployeeServiceImpl;
import com.alok.services.Impl.ValidateEmployeeServiceImpl;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;
@Import(library = {"context:jquery/age-validation.js"})
public class EditEmployee {
    @Inject
    private Logger logger;

    @Inject
    private AlertManager alertManager;

    @InjectComponent
    private Form edit;

    @InjectComponent("firstName")
    private TextField firstNameField;

    @InjectComponent("lastName")
    private TextField lastNameField;

    @InjectComponent("age")
    private TextField ageField;

    @InjectPage
    private SingleEmployee singleEmployee;

    @Property
    private String firstName;

    @Property
    private String lastName;

    @Property
    private Integer age;

    @Property
    private long personId;


    @Inject
    private ValidateEmployeeServiceImpl validateEmployeeServiceImpl;

    @Inject
    private EmployeeServiceImpl employeeServiceImpl;

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
        return personId;
    }
    void onValidateFromEdit() {
        if(age==null || firstName==null || lastName==null || firstName.equals("") || lastName.equals("")) {
            edit.recordError(firstNameField, " Invalid! ");
            edit.recordError(lastNameField, " Invalid! ");
        }
    }

    Object onSuccessFromEdit() {
        employeeServiceImpl.update(personId,firstName,lastName,age);
        logger.info("Updated successful!");
        singleEmployee.set(personId);
        return singleEmployee;
    }

    void onFailureFromEdit() {
        logger.warn("Update error!");
        alertManager.error("I'm sorry but I can't Update!");
    }

}
