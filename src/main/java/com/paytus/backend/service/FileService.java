package com.paytus.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;

@Service
public class FileService {
    public static void saveFile(MultipartFile mf, String datadir) {
        byte[] databyte;
        String dataname = mf.getOriginalFilename();

        try {
            // 파일의 내용을 바이트 배열로 변환하여 databyte에 저장
            databyte = mf.getBytes();

            // FileInputStream, FileOutputStream 은 바이트 단위로 데이터를 읽어들이는 클래스
            // 기존의 파일이 없으면 만들어지고 있으면 덮어쓰고 기존 파일내용은 제거
            FileOutputStream fo = new FileOutputStream(datadir + dataname);

            // 바이트 단위로 입력받은 내용을 파일 내용으로 기록
            fo.write(databyte);

            // 사용이 끝나면 파일 스트림 닫기
            fo.close();
            System.out.println("upload success");

        } catch (Exception e) {

        }

    }

}
