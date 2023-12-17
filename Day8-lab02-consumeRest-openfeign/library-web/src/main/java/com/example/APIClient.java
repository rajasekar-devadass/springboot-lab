package com.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "STUDENT-SERVICE", url = "http://localhost:9090/student")
public interface APIClient {
    @PostMapping("/")
    public Student add(@RequestBody Student student);

    @GetMapping("/")
    public List<Student> getAll();

    @GetMapping("/{id}")
    public Student get(@PathVariable int id);
}
