package com.alok.dao;

import com.alok.entities.Employee;


import java.util.List;

public interface EmployeeDao {
     Employee findById(Long id);
     Employee findByEmail(String email);
     List<Employee> findAll();
     void save(Employee employee);
}
