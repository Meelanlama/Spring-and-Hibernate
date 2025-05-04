package com.milan.cruddemo.Dao;

import com.milan.cruddemo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //define fields for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
       return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //Create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

        //return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findByFirstName(String theFirstName) {
        //Create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where firstName = :firstName", Student.class);

        //set query parameter
        query.setParameter("firstName", theFirstName);

        //return query results
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numberOfRowsAffected = entityManager.createQuery("DELETE from Student")
                .executeUpdate();
        return numberOfRowsAffected;
    }

}
