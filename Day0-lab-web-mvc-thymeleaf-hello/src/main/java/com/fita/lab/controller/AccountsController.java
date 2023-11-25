package com.fita.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountsController {

    @RequestMapping("/accounts")
    public String getAccounts(){
        return "accounts.html";
    }
}
