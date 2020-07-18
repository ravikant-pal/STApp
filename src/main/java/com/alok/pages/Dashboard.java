package com.alok.pages;

import com.alok.dto.EmployeeDTO;
import com.alok.entities.Employee;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class Dashboard {

    @Property
    private long personId;

    @Inject
    private Session session;

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
        employee = (Employee)session.createCriteria(Employee.class)
                .add(Restrictions.eq("id", personId)).uniqueResult();
        return personId;
    }
}
