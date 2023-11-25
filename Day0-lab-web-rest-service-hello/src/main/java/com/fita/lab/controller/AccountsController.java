package com.fita.lab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountsController {

    @GetMapping("/accounts")
    public Map<String, String> getAccounts() {
        Map<String, String> data = new HashMap<>();
        data.put("user1", "Staff");
        data.put("user2", "Admin");
        data.put("user3", "Student");
        return data;
    }
}
