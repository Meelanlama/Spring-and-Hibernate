package com.milan.Rest.Apis.Rest;

import com.milan.Rest.Apis.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // define @PostConstruct to load the student data... only once
    @PostConstruct
    public void init() {
        students = new ArrayList<Student>();

        students.add(new Student("Milan","Lama"));
        students.add(new Student("Bob","Lama"));
        students.add(new Student("Mario","Lama"));
    }

    // define end points for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    // define end points for "/students/{studentId}" - return a student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        //just indexing of the list(0,1,2)
        //check the studentId in the list
        if((studentId >= students.size()) || (studentId < 0) ){
            throw new  StudentNotFoundException("Student id not found: "+studentId);
        }
        return students.get(studentId);
    }

}
