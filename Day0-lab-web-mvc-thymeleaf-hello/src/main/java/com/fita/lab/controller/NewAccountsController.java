package com.fita.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewAccountsController {

    @RequestMapping("/accounts2")
    public String getAccounts(Model model){
        model.addAttribute("dynamicContent", "This paragraph content is dynamic");
        return "accounts.html";
    }
}
