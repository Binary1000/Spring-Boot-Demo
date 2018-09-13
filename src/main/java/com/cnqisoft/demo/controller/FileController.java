package com.cnqisoft.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileController {

    @PostMapping("file")
    public String upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        File localFile = new File("C:///Users/Administrator/Desktop/1.txt");
        System.out.println(localFile);
        file.transferTo(localFile);
        return "success";
    }

}
