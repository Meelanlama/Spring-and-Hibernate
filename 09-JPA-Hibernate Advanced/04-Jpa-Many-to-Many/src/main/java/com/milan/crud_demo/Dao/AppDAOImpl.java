package com.milan.crud_demo.Dao;

import com.milan.crud_demo.entity.Course;
import com.milan.crud_demo.entity.Instructor;
import com.milan.crud_demo.entity.InstructorDetail;
import com.milan.crud_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        List<Course> courses = tempInstructor.getCourses();

        //break associations of all courses for instructor
        //remove instructor for all courses
        for (Course course : courses) {
            course.setInstructor(null);
        }

        //delete instructor
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

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        //create query
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id=:instructorId", Course.class);
        query.setParameter("instructorId", theId);

        //execute query
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        //create query
        TypedQuery<Instructor> query = entityManager.createQuery(
                                    "select i from Instructor i "
                                        + "JOIN fetch i.courses "
                                        + "JOIN fetch i.instructorDetailId"
                                        + " where i.id=:instructorId", Instructor.class);

        query.setParameter("instructorId", theId);

        //execute
       return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor theInstructor) {
        entityManager.merge(theInstructor);
    }

    @Override
    @Transactional
    public void update(Course theCourse) {
        entityManager.merge(theCourse);
    }

    @Override
    public Course findCourseById(int theId) {
       return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        //retrieve course
        Course tempCourse = entityManager.find(Course.class, theId);
        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsById(int theId) {
        //create query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                + "join fetch c.reviews  "
                + " where c.id=:courseId", Course.class);

        query.setParameter("courseId", theId);

        //execute
        return query.getSingleResult();
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int theId) {
        //create query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                        + "join fetch c.students  "
                        + " where c.id=:courseId", Course.class);

        query.setParameter("courseId", theId);

        //execute
        return query.getSingleResult();

    }

    @Override
    public Student findStudentsAndCourseByStudentId(int theId) {
        //create query
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s "
                        + "join fetch s.course"
                        + " where s.id=:data", Student.class);

        query.setParameter("data", theId);

        //execute
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int theId) {

        //retrieve student
        Student tempStudent = entityManager.find(Student.class, theId);

        if(tempStudent != null) {

            //get courses
            List<Course> courses = tempStudent.getCourse();

            //break association of all courses for student
            for(Course tempCourse : courses) {
                tempCourse.getStudents().remove(tempStudent);
            }

            //delete student
            entityManager.remove(tempStudent);
        }
    }
}
