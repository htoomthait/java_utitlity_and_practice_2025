package com.example.liquid.database.practice.controller;


import com.example.liquid.database.practice.dto.CustomRespond;
import com.example.liquid.database.practice.service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/files")
public class FileController extends BaseController{


    private final FileService fileService;
    private static final List<String> ALLOWED_TYPES = List.of(
            "image/jpeg", "image/png", "application/pdf",
            "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
    );

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<CustomRespond<String>> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        // Validate file type
        if (!ALLOWED_TYPES.contains(file.getContentType())) {
            String errorMessage = "Invalid file type! Allowed types are: " + String.join(", ", ALLOWED_TYPES);
            return createResponse(
                    HttpStatus.BAD_REQUEST,
                    "error",
                    "FIL002",
                    errorMessage,
                    null
            );
        }

        // Validate size (optional - already limited in application.properties)
        if (file.getSize() > 5 * 1024 * 1024) {
            String errorMessage = "File size exceeds the limit of 5MB.";
            return createResponse(
                    HttpStatus.BAD_REQUEST,
                    "error",
                    "FIL003",
                    errorMessage,
                    null
            );
        }


        // returning a successful response
        return createResponse(
                HttpStatus.OK,
                "success",
                "FIL001",
                "File uploaded successfully",
                fileService.makeFileUpload(file)
        );
    }
}
