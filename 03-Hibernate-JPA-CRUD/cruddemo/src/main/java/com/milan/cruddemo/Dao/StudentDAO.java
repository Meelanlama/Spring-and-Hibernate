package com.milan.cruddemo.Dao;

import com.milan.cruddemo.Entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByFirstName(String theFirstName);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();

}
