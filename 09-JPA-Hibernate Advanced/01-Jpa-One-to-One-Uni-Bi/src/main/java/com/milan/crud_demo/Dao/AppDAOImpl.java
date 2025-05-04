package com.milan.crud_demo.Dao;

import com.milan.crud_demo.entity.Instructor;
import com.milan.crud_demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{

    //Define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        //retrieve instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        //delete
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        //retrieve instructor
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        //Remove the associated object reference
        //break bidirectional link
        tempInstructorDetail.getInstructor().setInstructorDetailId(null);

        //delete
        entityManager.remove(tempInstructorDetail);
    }

}
