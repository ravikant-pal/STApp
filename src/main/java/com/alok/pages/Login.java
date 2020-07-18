package com.alok.pages;

import com.alok.entities.Employee;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;

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

  @Inject
  private Session session;

  @InjectPage
  private Dashboard dashboard;

  @Property
  private String email;

  @Property
  private String password;

  @InjectPage
  private Details details;


  void onValidateFromLogin() {
    Criteria criteria = session.createCriteria(Employee.class)
            .add(Restrictions.eq("email", email));

    Object result = criteria.uniqueResult();
    if (result != null) {
      Employee employee = (Employee) result;
      if(!(employee.getEmail().equals(email) && employee.getPassword().equals(password))) {
        login.recordError(emailField, " Invalid! ");
        login.recordError(passwordField, " Invalid! ");
      }
    } else  {
      login.recordError(emailField, " Invalid! ");
      login.recordError(passwordField, " Invalid! ");
    }
  }


  Object onSuccessFromLogin() {
    Employee employee = (Employee)session.createCriteria(Employee.class)
            .add(Restrictions.eq("email", email)).uniqueResult();
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
