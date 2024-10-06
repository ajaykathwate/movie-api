package com.movieapi.controllers;

import com.movieapi.service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/file/")
public class FileController {

    @Autowired
    private final FileService fileService;

    @Value("${project.posters}")
    private String path;

    public FileController (FileService fileService){
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String>  uploadFileHandler(@RequestPart MultipartFile file) throws IOException{
        String uploadedFilename = fileService.uploadFile(path, file);

        return new ResponseEntity<String>(uploadedFilename, HttpStatus.OK);
    }

    @GetMapping("/{filename}")
    public void serveFileHandler(@PathVariable String filename, HttpServletResponse response) throws IOException {
        InputStream resourceFile = fileService.getResourceFile(path, filename);
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        StreamUtils.copy(resourceFile, response.getOutputStream());
    }

}
