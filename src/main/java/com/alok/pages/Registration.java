package com.alok.pages;

import com.alok.dto.EmployeeRegistrationDTO;
import com.alok.entities.Employee;
import com.alok.services.Impl.EmployeeServiceImpl;
import org.apache.tapestry5.alerts.AlertManager;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.*;
import org.apache.tapestry5.ioc.annotations.Inject;

import org.slf4j.Logger;

import java.util.Date;

@Import(stylesheet = {"context:css/style.css"})
public class Registration {
    @Inject
    private Logger logger;

    @Inject
    private AlertManager alertManager;

    @InjectComponent
    private Form register;

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

    @InjectComponent("dob")
    private DateField dobField;

    @Property
    private String firstName;

    @Property
    private String lastName;

    @Property
    private String email;

    @Property
    private String password;

    @Property
    private String image;

    @Property
    private String age;

    @Property
    private String address;

    @Property
    private Date dob;

    @Property
    // We could return a DateFormat, but instead we'll return a String which DateField will coerce into a DateFormat.
    private String dateInFormatStr = "dd/MM/yyyy";




    @Inject
    private EmployeeServiceImpl employeeServiceImpl;

    @InjectPage
    private Login login;

    @Property
    EmployeeRegistrationDTO newEmployee;


    void onValidateFromRegister() {
        if(firstName==null || firstName.equals("")) {
            register.recordError(firstNameField, " Invalid!");
        }
        if(lastName==null || lastName.equals("")) {
            register.recordError(lastNameField, " Invalid!");
        }
        if(email==null || email.equals("")) {
            register.recordError(emailField, " Invalid!");
        }
        if(password==null || password.equals("")) {
            register.recordError(passwordField, " Invalid!");
        }
        if(image==null || image.equals("")) {
            register.recordError(imageField, " Invalid!");
        }
        if(age==null || age.equals("")) {
            register.recordError(ageField,"Invalid!");
        }
        if(address==null || address.equals("")) {
            register.recordError(addressField,"Invalid!");
        }
        if(dob==null) {
            register.recordError(dobField,"Invalid!");
        }

    }
    Object onSuccessFromRegister() {
        Employee newEmployee = new Employee(firstName,lastName,email,password,image,Integer.parseInt(age),address,dob);
        employeeServiceImpl.save(newEmployee);
        logger.info("Registration successful!");
        logger.info(firstName+ lastName+ email+ password+ image+ age+ address+ dob);
        alertManager.success("Registration successful, Please Login!");
        return login;
    }
}
