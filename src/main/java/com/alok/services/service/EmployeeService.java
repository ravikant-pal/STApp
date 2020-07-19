package com.alok.services.service;


import com.alok.entities.Employee;
import com.alok.services.Impl.EmployeeDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService   {

   @Autowired
   EmployeeDaoRepository employeeDaoRepository;


   public Employee getById(Long id) {
      return employeeDaoRepository.findById(id);
   }


   public Employee getByEmail(String email) {
      return employeeDaoRepository.findByEmail(email);
   }


   public List<Employee> getAll() {
      return employeeDaoRepository.findAll();
   }


   public void save(Employee employee) {
      employeeDaoRepository.save(employee);
   }



}
