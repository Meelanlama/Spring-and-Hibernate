package com.milan.crud_demo;

import com.milan.crud_demo.Dao.AppDAO;
import com.milan.crud_demo.entity.Instructor;
import com.milan.crud_demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

			deleteInstructorDetail(appDAO);
		};
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
		int theId = 2;

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
