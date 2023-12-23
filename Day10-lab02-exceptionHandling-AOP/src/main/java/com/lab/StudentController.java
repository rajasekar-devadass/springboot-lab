package com.lab;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
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
    public ResponseEntity<Student> add(@RequestBody @Valid Student student) {
        student.setId(studentList.size());
        studentList.add(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Student> put(@RequestBody @Valid Student inputStudent) {
        for (int index = 0; index < studentList.size(); index++) {
            Student studentObj = studentList.get(index);
            if (studentObj.getId() == inputStudent.getId()) {
                studentList.set(index, inputStudent);
                return new ResponseEntity<>(inputStudent, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(inputStudent, HttpStatus.NOT_MODIFIED);
    }

    @PatchMapping("/")
    public ResponseEntity<Student> patch(@RequestBody @Valid Student inputStudent) {
        for (int index = 0; index < studentList.size(); index++) {
            Student studentObj = studentList.get(index);
            if (studentObj.getId() == inputStudent.getId()) {
//                studentList.set(index, inputStudent);
                studentObj.setName(inputStudent.getName());
                return new ResponseEntity<>(inputStudent, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(inputStudent, HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable int id) {
        for (Student studentObj : studentList) {
            if (studentObj.getId() == id) {
                return new ResponseEntity<>(studentObj, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAll() {
        if (studentList == null || studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(studentList, HttpStatus.OK);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student obj = iterator.next();
            if (obj.getId() == id) {
                iterator.remove();
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
