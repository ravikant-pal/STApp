package com.alok.services.Impl;

import com.alok.entities.Employee;
import com.alok.services.ValidateEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateEmployeeServiceImpl implements ValidateEmployeeService {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @Override
    public boolean validate(String email,String password) {
        Employee employee = employeeServiceImpl.getByEmail(email);
        if (employee != null) {
            return employee.getEmail().equals(email) && employee.getPassword().equals(password);
        } else  {
            return false;
        }

    }
}
