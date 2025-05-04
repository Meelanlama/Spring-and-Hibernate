package com.milan.CrudDemo.DAO;

import com.milan.CrudDemo.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    //Define fields for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    public EmployeeDAOImpl() {}

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        //GET EMPLOYEE
        Employee employee = entityManager.find(Employee.class, id);

        //RETURN EMPLOYEE
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        //GET EMPLOYEE
        Employee employee1 = entityManager.merge(employee);

        //RETURN EMPLOYEE
        return employee1;
    }

    @Override
    public void deleteById(int id) {
        //GET EMPLOYEE
        Employee employee = entityManager.find(Employee.class, id);

        //RETURN EMPLOYEE
        entityManager.remove(employee);
    }
}
