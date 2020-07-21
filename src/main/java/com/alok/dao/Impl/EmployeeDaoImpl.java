package com.alok.dao.Impl;

import com.alok.dao.EmployeeDao;
import com.alok.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Employee findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Employee) session.createCriteria(Employee.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public Employee findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        return (Employee) session.createCriteria(Employee.class)
                .add(Restrictions.eq("email", email)).uniqueResult();
    }

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Employee.class).list();
    }

    @Override
    public void save(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

}
