package com.example.trainmanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class TrainController {

    @RequestMapping("/welcome")
    public String welcome() {
        return "Welcome to Train Management System";
    }

}