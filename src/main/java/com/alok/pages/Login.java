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
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

@Import(stylesheet = {"context:css/style.css"})
public class Login {

  @Inject
  private Logger logger;

  @Inject
  private AlertManager alertManager;

  @InjectComponent
  private Form login;
  
  @InjectComponent("email")
  private TextField emailField;
  
  @InjectComponent("password")
  private PasswordField passwordField;

  @InjectPage
  private Dashboard dashboard;

  @Property
  private String email;

  @Property
  private String password;

  @InjectPage
  private AllEmployee allEmployee;

  @Inject
  private ValidateEmployeeServiceImpl validateEmployeeServiceImpl;

  @Inject
  private EmployeeServiceImpl employeeServiceImpl;

  void onValidateFromLogin() {
    logger.info(validateEmployeeServiceImpl+"=================================>");
    if(!validateEmployeeServiceImpl.validate(email,password)) {
      login.recordError(emailField, " Invalid! ");
      login.recordError(passwordField, " Invalid! ");
    }
  }


  Object onSuccessFromLogin() {
    Employee employee = employeeServiceImpl.getByEmail(email);
    logger.info("Login successful!");
    alertManager.success("Welcome aboard!");
    dashboard.set(employee.getId());
    return dashboard;
  }

  void onFailureFromLogin() {
    logger.warn("Login error!");
    alertManager.error("I'm sorry but I can't log you in!");
  }
}
