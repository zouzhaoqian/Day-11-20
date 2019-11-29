package com.zou.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JunitController {
    @RequestMapping("/selectAll")
    public String selectAll(){
        return "hanpi";
    }
}
