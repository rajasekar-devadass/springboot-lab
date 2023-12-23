package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {


    private WebClient webClient;

    @Autowired
    public void setWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping
    public String showAllBooks(Model model) {
        //Retrieve
        List<Student> studentList = webClient.get().uri("/").retrieve().bodyToMono(new ParameterizedTypeReference<List<Student>>() {
        }).block();
        //sync - blocked untill getting the responsse
        //Async - execution will not be block, request will be parrallely computed
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

//        Student studentList = webClient.post().uri("/").body(BodyInserters.fromValue(studentObj)).retrieve().bodyToMono(Student.class).block();

        //Exchange
        Student response = webClient
                .post()
                .uri("/")
                .body(BodyInserters.fromValue(studentObj))
                .exchangeToMono(clientResponse -> {
                            if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                                return clientResponse.bodyToMono(Student.class);
                            } else {
                                return clientResponse.createException().flatMap(Mono::error);
                            }
                        }
                )
                .block(); // Blocking call to wait for the response

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
