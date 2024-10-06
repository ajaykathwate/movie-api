package com.movieapi.service.implementation;

import com.movieapi.service.FileService;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileServiceImpl implements FileService {


    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {

        // get file name
        String fileName = file.getOriginalFilename();

        // get file path
        String filePath = path + File.separator + fileName;

        // create file object
        File fileObj = new File(filePath);

        if(!fileObj.exists()){
            fileObj.mkdir();
        }

        // copy and upload file to teh path
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);


        return fileName;
    }

    @Override
    public InputStream getResourceFile(String path, String filename) throws FileNotFoundException {

        String filePath = path + File.separator + filename;



        return new FileInputStream(filePath);
    }
}
