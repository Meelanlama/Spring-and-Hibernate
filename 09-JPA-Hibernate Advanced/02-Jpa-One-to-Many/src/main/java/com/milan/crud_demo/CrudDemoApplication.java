package com.milan.crud_demo;

import com.milan.crud_demo.Dao.AppDAO;
import com.milan.crud_demo.entity.Course;
import com.milan.crud_demo.entity.Instructor;
import com.milan.crud_demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return  runner ->{
			//createInstructor(appDAO);

			//findInstructor(appDAO);
			
			//deleteInstructor(appDAO);

			//findInstructorDetail(appDAO);

			//deleteInstructorDetail(appDAO);

			//createInstructorWithCourses(appDAO);
			
			//findInstructorWithCourses(appDAO);

			//findCoursesForInstructor(appDAO);

			//findInstructorWithCoursesJoinFetch(appDAO);

			//updateInstructor(appDAO);

			//updateCourse(appDAO);
			
			deleteCourse(appDAO);

		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting Course " + theId);

		appDAO.deleteCourseById(theId);
		System.out.println("Deleted Course");
	}

	private void updateCourse(AppDAO appDAO) {
		//find course by id
		int theId = 10;
		System.out.println("Updating course: " + theId);
		Course theCourse = appDAO.findCourseById(theId);

		//update
		theCourse.setTitle("Test Course");
		appDAO.update(theCourse);

		System.out.println("Done updating course");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		Instructor theInstructor = appDAO.findInstructorById(theId);
		theInstructor.setFirstName("Test");

		appDAO.update(theInstructor);
		System.out.println("Done updating instructor");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;

		// find instructor
		System.out.println("Finding Instructor with Id: " + theId);
		Instructor theInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("Instructor: " + theInstructor);
		System.out.println("Associated Courses: " +theInstructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;

		// find instructor
		Instructor theInstructor = appDAO.findInstructorById(theId);
		System.out.println("Found Instructor: " +theInstructor);

		//find courses for instructor
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		//associate objects
		theInstructor.setCourses(courses);

		System.out.println("Associated Courses: " +theInstructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Found instructor: " + tempInstructor);
		System.out.println("Associated courses: " + tempInstructor.getCourses());

		System.out.println("Done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		//CREATE INSTRUCTOR
		Instructor tempInstructor = new Instructor("Bob","Lama","boblama@gmail.com");

		//create instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("Travelling","www.youtube.com/bob77");

		//associate the objects
		tempInstructor.setInstructorDetailId(tempInstructorDetail);

		//create some courses
		Course tempCourse = new Course("Java");
		Course tempCourse1 = new Course("Python");

		//add course to instructor
		tempInstructor.add(tempCourse);
		tempInstructor.add(tempCourse1);

		//saving instructor
		//Note: This will also save course
		System.out.println("Saving Instructor: "+tempInstructor);
		System.out.println("Courses:" + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Saved");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Deleted Instructor Details with id " + theId);

	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Find InstructorDetail with id " + theId);
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println("Found Instructor Detail: " + tempInstructorDetail);
		System.out.println("Associated Instructor only: " + tempInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Delete instructor with id " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Deleted Instructor with id " + theId);
	}

	// Find Instructor by id
	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Find Instructor with id " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Found Instructor: " + tempInstructor);
		System.out.println("Associated Instructor Details only: " + tempInstructor.getInstructorDetailId());
	}

	private void createInstructor(AppDAO appDAO) {

		/*

		//CREATE INSTRUCTOR
		Instructor tempInstructor = new Instructor("Milan","Lama","Lamamilan@gmail.com");

		//create instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("Football","http://www.milantamang.com/youtube");

		//associate the objects
		tempInstructor.setInstructorDetailId(tempInstructorDetail);

		 */

		//CREATE INSTRUCTOR
		Instructor tempInstructor = new Instructor("Ram","Lama","ram@gmail.com");

		//create instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("Study","http://www.ram.com/youtube");

		//associate the objects
		tempInstructor.setInstructorDetailId(tempInstructorDetail);

		//save
		//NOTE: this will also save the details object because of cascade type all
		System.out.println("Saving instructor: " + tempInstructor + tempInstructorDetail);
		appDAO.save(tempInstructor);
		System.out.println("Done saving...");

	}

}
