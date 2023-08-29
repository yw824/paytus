package com.paytus.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;

@Service
public class FileService {
    public static void saveFile(MultipartFile mf, String datadir) {
        byte[] databyte;
        String dataname = mf.getOriginalFilename();
        System.out.println("upload file: "+dataname);
        try {
            databyte = mf.getBytes();
            FileOutputStream fo = new FileOutputStream(datadir + dataname);
            fo.write(databyte);
            fo.close();
            System.out.println("upload success");
        } catch (Exception e) {

        }

    }

}
