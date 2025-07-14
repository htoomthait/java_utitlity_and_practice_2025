package com.example.liquid.database.practice.controller;

import com.example.liquid.database.practice.dto.CustomRespond;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController extends BaseController{

    @GetMapping
    public String welcome(){
        return "Welcome to the Liquid Database Practice Application";
    }

    @GetMapping("/home")
    public ResponseEntity<CustomRespond<String>> home() {



        return  createResponse(
                HttpStatus.OK,
                "success",
                "WH001",
                "Welcome to the Liquid Database Practice Application",
                null
        );


    }
}
