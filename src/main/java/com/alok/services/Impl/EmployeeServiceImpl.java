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

    public void save(Employee newEmployee) {
        employeeDao.save(newEmployee);
    }
    public void update(Long id,String firstName,String lastName, int age) {
        Employee employee = employeeDao.findById(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
//        employeeDao.save(employee);
    }

    public Employee update(Employee editedEmployee) {
        Employee employee = employeeDao.findById(editedEmployee.getId());
        employee.setFirstName(editedEmployee.getFirstName());
        employee.setLastName(editedEmployee.getLastName());
        employee.setEmail(editedEmployee.getEmail());
        employee.setPassword(editedEmployee.getPassword());
        employee.setAddress(editedEmployee.getAddress());
        employee.setAge(editedEmployee.getAge());
        employee.setImage(editedEmployee.getImage());
        employee.setDob(editedEmployee.getDob());
        return employee;
    }
}
