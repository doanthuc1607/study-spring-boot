package com.luv2code.cruddemo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BirthdayController {

    @GetMapping("/account")
    public String birthday() {
        return "birthday";
    }
}