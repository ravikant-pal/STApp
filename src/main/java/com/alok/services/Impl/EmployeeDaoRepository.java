package com.alok.services.Impl;


import com.alok.entities.Employee;
import com.alok.services.dao.EmployeeDao;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDaoRepository implements EmployeeDao<Employee,Long> {
    @Autowired
    private Session session;

    @Override
    public Employee findById(Long id) {
        return (Employee) session.createCriteria(Employee.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public Employee findByEmail(String email) {
        return (Employee) session.createCriteria(Employee.class)
                .add(Restrictions.eq("email", email)).uniqueResult();
    }

    @Override
    public List<Employee> findAll() {
        return session.createCriteria(Employee.class).list();
    }

    @Override
    public void save(Employee employee) {
        session.persist(employee);
    }
}
