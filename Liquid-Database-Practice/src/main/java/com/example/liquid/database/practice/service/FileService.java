package com.example.liquid.database.practice.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    String makeFileUpload(MultipartFile file) throws IOException;
}
