package com.example.liquid.database.practice.controller;

import com.example.liquid.database.practice.dto.CustomRespond;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * BaseController provides common functionality for all controllers in the application.
 * It includes a method to create a standardized response format.
 */
public class BaseController {


    protected <T> CustomRespond<T> createResponse(String status, String respondCode, String message, T data) {

        return  CustomRespond.of(respondCode, status, message, data);

    }
}
