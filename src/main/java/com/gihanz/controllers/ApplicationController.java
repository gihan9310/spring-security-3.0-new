package com.gihanz.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class ApplicationController {

    @GetMapping(value = "/rest")
    public String welcome(){
        return  "Welcome.";
    }
}
