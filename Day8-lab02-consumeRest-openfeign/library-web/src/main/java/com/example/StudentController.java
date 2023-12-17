package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {

    @Autowired
    private APIClient apiClient;

    public APIClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(APIClient apiClient) {
        this.apiClient = apiClient;
    }

    @GetMapping
    public String showAllBooks(Model model) {
        //Retrieve
        List<Student> studentList = apiClient.getAll();
        model.addAttribute("students", studentList);
        return "allStudents";
    }


    @GetMapping("/addStudentFormAction")
    public String getAddStudentForm(Model model) {
        model.addAttribute("studentObj", new Student());
        return "addStudentForm";
    }

    @PostMapping("/saveStudent")
    public String addStudent(Model model, @ModelAttribute Student studentObj) {
        apiClient.add(studentObj);
        Student obj = apiClient.get(studentObj.getId());
        return "redirect:/";
    }


//    @GetMapping("/")
//    public List<Student> getAll() {
//        return studentList;
//    }
//
//    @PutMapping("/")
//    public Student put(@RequestBody Student student) {
//        studentList.set(student.getId(), student);
//        return student;
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable int id) {
//        studentList.remove(id);
//    }


}
