package com.milan.cruddemo;

import com.milan.cruddemo.Dao.StudentDAO;
import com.milan.cruddemo.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner ->{
			//createStudent(studentDAO);

			createMultipleStudent(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForFirstName(studentDAO);

			//queryForUpdate(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int rows = studentDAO.deleteAll();
		System.out.println("Number of rows deleted: " + rows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// delete student
		int studentId = 2;
		System.out.println("Deleting student of id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void queryForUpdate(StudentDAO studentDAO) {
		//get a student based on primary key
		int id = 1;
		System.out.println("Getting student with id " + id);
		Student student = studentDAO.findById(id);

		// change first name ho "Test", "Milan"
		System.out.println("Updating student with id " + id);
		student.setFirstName("Milan");

		// update student with the DAO method
		studentDAO.update(student);

		// display updated student
		System.out.println("Updated student:" + student);

	}

	private void queryForFirstName(StudentDAO studentDAO) {
		//Get a student
		List<Student> student = studentDAO.findByFirstName("Milan");

		//display student
		for (Student s : student) {
			System.out.println(s);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//Get a list of students
		List<Student> students = studentDAO.findAll();

		//display list of students
		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create student
		System.out.println("Creating student object....");
		Student tempStudent = new Student("Mbappe", "Hero", "mbappe@gmail.com");

		//save student
		System.out.println("Saving student ....");
		studentDAO.save(tempStudent);

		//display id of saved student
		int idOfStudent = tempStudent.getId();
		System.out.println("Saved student id is:" + idOfStudent);

		//retrieve student based on id: pk
		System.out.println("Retrieving saved student name with:" + idOfStudent);
		Student retrievedStudent = studentDAO.findById(idOfStudent);

		//display student details
		System.out.println("Retrieved saved all details: " + retrievedStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		//create multiple student object
		System.out.println("Creating student objects....");
		Student tempStudent1 = new Student("Hero", "Lama", "hero@gmail.com");
		Student tempStudent2 = new Student("John", "Doe", "john@gmail.com");
		Student tempStudent3 = new Student("Bob", "Dylan", "bobdylan@gmail.com");

		//save all student objects
		System.out.println("Saving students ....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create student object
		System.out.println("Creating student object....");
		Student tempStudent = new Student("Milan", "Lama", "milan@gmail.com");

		//save student object
		System.out.println("Saving student ....");
		studentDAO.save(tempStudent);

		//display student object
		System.out.println("Saving student complete...." + tempStudent.toString());
	}
}

