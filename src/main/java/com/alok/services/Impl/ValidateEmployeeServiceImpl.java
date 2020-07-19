package com.alok.services.Impl;

import com.alok.entities.Employee;
import com.alok.services.service.ValidateEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateEmployeeServiceImpl implements ValidateEmployeeService {

    @Autowired
    private EmployeeDaoRepository employeeDao;

    @Override
    public boolean validate(String email,String password) {
        Employee employee = employeeDao.findByEmail(email);
        if (employee != null) {
            return employee.getEmail().equals(email) && employee.getPassword().equals(password);
        } else  {
            return false;
        }

    }
}
