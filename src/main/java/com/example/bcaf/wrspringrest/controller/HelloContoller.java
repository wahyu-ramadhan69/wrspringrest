package com.example.bcaf.wrspringrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloContoller {
    @GetMapping("/cook")
    public String firstPage() {
        return "data";
    }
}
