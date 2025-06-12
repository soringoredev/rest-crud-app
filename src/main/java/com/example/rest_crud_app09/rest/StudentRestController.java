package com.example.rest_crud_app09.rest;

import com.example.rest_crud_app09.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> theStudents;


    // definim @PostConstructor ca sa incercam studentii nostri o singura data
    @PostConstruct
    public void loadData() {

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Muntean", "Eugen"));
        theStudents.add(new Student("Ojog", "Maria"));
        theStudents.add(new Student("Gonzales", "Pedro"));


    }

    // definim endpointu-ul pentru students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // definim un endoint ca sa afisam toti studentii nostri dupa index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if ( (studentId >= theStudents.size()) || (studentId < 0 )) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);

    }
}
