package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private int studentCountForID;
    private final List<Student> studentList;

    public StudentController() {
        studentList = new LinkedList<>();
        studentCountForID = 0;
    }

    @PostMapping("/")
    //O(1)
    public Student add(@RequestBody Student student) {
        studentCountForID++;
        student.setId(studentCountForID);
        studentList.add(student);
        return student;
    }

    @PutMapping("/")
    //O(n)
    //HashMap - O(1)
    public Student put(@RequestBody Student inputStudent) {
        for (int index = 0; index < studentList.size(); index++) {
            Student studentObj = studentList.get(index);
            if (studentObj.getId() == inputStudent.getId()) {
                studentList.set(index, inputStudent);
                return inputStudent;
            }
        }
        return null;
    }

    @PatchMapping("/")
    public Student patch(@RequestBody Student inputStudent) {
        for (int index = 0; index < studentList.size(); index++) {
            Student studentObj = studentList.get(index);
            if (studentObj.getId() == inputStudent.getId()) {
//                studentList.set(index, inputStudent);
                studentObj.setName(inputStudent.getName());
                return inputStudent;
            }
        }
        return null;
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable int id) {
        for (Student studentObj : studentList) {
            if (studentObj.getId() == id) {
                return studentObj;
            }
        }
        return null;
    }

    @GetMapping("/")
    public List<Student> getAll() {
        return studentList;
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student obj = iterator.next();
            if (obj.getId() == id) {
                iterator.remove();
            }
        }

        studentList.remove(id);
    }


}
