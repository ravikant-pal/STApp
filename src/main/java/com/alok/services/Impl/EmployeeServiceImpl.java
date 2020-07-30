package com.alok.services.Impl;


import com.alok.dao.EmployeeDao;
import com.alok.dto.EmployeeRegistrationDTO;
import com.alok.entities.Employee;
import com.alok.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee getById(Long id) {
        return employeeDao.findById(id);
    }

    public Employee getByEmail(String email) {
        return employeeDao.findByEmail(email);
    }
    public List<Employee> getAll() {
        return employeeDao.findAll();
    }

    public void save(EmployeeRegistrationDTO newEmployee) {
        Employee employee = new Employee(
                newEmployee.getFirstName(),
                newEmployee.getLastName(),
                newEmployee.getAge(),
                newEmployee.getAddress(),
                newEmployee.getEmail(),
                newEmployee.getPassword());
        employeeDao.save(employee);
    }
    public void update(Long id,String firstName,String lastName, int age) {
        Employee employee = employeeDao.findById(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
//        employeeDao.save(employee);
    }
}
