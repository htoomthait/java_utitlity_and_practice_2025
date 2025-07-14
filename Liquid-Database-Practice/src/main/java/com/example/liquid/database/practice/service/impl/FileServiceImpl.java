package com.example.liquid.database.practice.service.impl;

import com.example.liquid.database.practice.service.FileService;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String makeFileUpload() {
        return "Made file upload successfully.";
    }
}
