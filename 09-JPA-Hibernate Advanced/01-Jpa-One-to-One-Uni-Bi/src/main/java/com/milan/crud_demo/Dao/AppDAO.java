package com.milan.crud_demo.Dao;

import com.milan.crud_demo.entity.Instructor;
import com.milan.crud_demo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);


}
