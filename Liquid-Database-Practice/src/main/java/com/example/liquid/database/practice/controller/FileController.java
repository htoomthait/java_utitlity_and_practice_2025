package com.example.liquid.database.practice.controller;


import com.example.liquid.database.practice.dto.CustomRespond;
import com.example.liquid.database.practice.service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/files")
public class FileController extends BaseController{

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<CustomRespond<String>> uploadFile() {




        // returning a successful response
        return createResponse(
                HttpStatus.OK,
                "success",
                "FIL001",
                "File uploaded successfully",
                fileService.makeFileUpload()
        );
    }
}
