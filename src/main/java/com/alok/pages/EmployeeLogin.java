package com.alok.pages;


import com.alok.models.Employee;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;


import java.util.ArrayList;
import java.util.List;

@Import(stylesheet = "context:css/style.css")
public class EmployeeLogin {
    private static final Logger logger = LogManager.getLogger(EmployeeLogin.class);

    @Inject
    private AlertManager alertManager;

    @InjectComponent
    private Form signin;

    @InjectComponent("email")
    private TextField emailField;

    @InjectComponent("password")
    private PasswordField passwordField;

    @Property
    private String email;

    @Property
    private String password;


    @InjectPage
    private EmployeeDetails employeeDetails;

    void onValidateFromSignin() {
        getListOfEmployee().forEach(emp -> {
            if(!emp.getEmail().equals(email)) {
                signin.recordError(emailField, " Invalid email");
            }
            if(!emp.getPassword().equals(password)) {
                signin.recordError(passwordField, " Invalid password");
            }
        });
    }

    Object onSuccessFromSignin() {
        logger.info("Login successful!");
        alertManager.success("Welcome aboard!");
        return employeeDetails;
//        return Index.class;
    }

    void onFailureFromSignin() {
        logger.warn("Login error!");
        alertManager.error("I'm sorry but I can't log you in!");
    }
    public List<Employee> getListOfEmployee() {
        List<Employee> listOfEmployee = new ArrayList<>();
        listOfEmployee.add(new Employee("xyz",123,"India","abc@abc.com","pass123"));
        listOfEmployee.add(new Employee("xyz",123,"India","abc@abc.com","pass123"));
        listOfEmployee.add(new Employee("xyz",123,"India","abc@abc.com","pass123"));
        listOfEmployee.add(new Employee("xyz",123,"India","abc@abc.com","pass123"));
        listOfEmployee.add(new Employee("xyz",123,"India","abc@abc.com","pass123"));
        listOfEmployee.add(new Employee("xyz",123,"India","abc@abc.com","pass123"));
        listOfEmployee.add(new Employee("xyz",123,"India","abc@abc.com","pass123"));

        return listOfEmployee;
    }

}
