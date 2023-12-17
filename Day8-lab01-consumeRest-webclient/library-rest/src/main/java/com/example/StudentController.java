package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final List<Student> studentList;

    public StudentController() {
        studentList = new LinkedList<>();
    }

    @PostMapping("/")
    public Student add(@RequestBody Student student) {
        student.setId(studentList.size());
        studentList.add(student);
        return student;
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable int id) {
        return studentList.get(id);
    }

    @GetMapping("/")
    public List<Student> getAll() {
        return studentList;
    }

    @PutMapping("/")
    public Student put(@RequestBody Student student) {
        studentList.set(student.getId(), student);
        return student;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentList.remove(id);
    }


}
