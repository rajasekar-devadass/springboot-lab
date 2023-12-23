package com.lab;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final List<Student> studentList;

    public StudentController() {
        studentList = new LinkedList<>();
    }

    @PostMapping("/")
    public ResponseEntity<Object> add(@RequestBody @Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                String fieldName = fieldError.getField();
                String errorMsg = fieldError.getDefaultMessage();
                errors.put(fieldName, errorMsg);
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        student.setId(studentList.size());
        studentList.add(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Student> put(@RequestBody Student inputStudent) {
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
    public ResponseEntity<Student> patch(@RequestBody Student inputStudent) {
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
