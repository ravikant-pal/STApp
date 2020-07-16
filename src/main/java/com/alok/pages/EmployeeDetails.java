package com.alok.pages;

import com.alok.models.Employee;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;

import java.util.ArrayList;
import java.util.List;

@Import(stylesheet = "context:css/style.css")
public class EmployeeDetails {

    @Property
    private List<Employee> employees;

    @Property
    private Employee employee;

    void setupRender() {
        // Get all persons - ask business service to find them (from the database)
        employees = getListOfEmployee();
    }

    public List<Employee> getListOfEmployee() {
        List<Employee> listOfEmployee = new ArrayList<>();
        listOfEmployee.add(new Employee("xyzab",90,"India","abc@abc.com","pass123"));
        listOfEmployee.add(new Employee("abffc",60,"India","abc@abc.com","pass123"));
        listOfEmployee.add(new Employee("addbd",12,"India","abc@abc.com","pass123"));
        listOfEmployee.add(new Employee("sdjsd",45,"India","abc@abc.com","pass123"));
        listOfEmployee.add(new Employee("xyzpo",23,"India","abc@abc.com","pass123"));
        listOfEmployee.add(new Employee("xyzaf",78,"India","abc@abc.com","pass123"));
        listOfEmployee.add(new Employee("xyzkl",34,"India","abc@abc.com","pass123"));

        return listOfEmployee;
    }
}
