package com.example.liquid.database.practice.service.impl;

import com.example.liquid.database.practice.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;

@Service
public class FileServiceImpl implements FileService {

    @Value("${file.upload-dir}")
    private String uploadDir;


    @Override
    public String makeFileUpload(MultipartFile file) throws IOException {

        try{
            // Generate UUID file name
            String extension = Objects.requireNonNull(file.getOriginalFilename())
                    .substring(file.getOriginalFilename().lastIndexOf('.'));
            String newFileName = UUID.randomUUID() + extension;


            // Save file to disk
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(newFileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return "Made file upload successfully. File saved as: " + newFileName;
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to upload file: " + e.getMessage();
        }
    }
}
