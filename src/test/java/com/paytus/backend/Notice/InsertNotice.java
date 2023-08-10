package com.paytus.backend.Notice;

import com.paytus.backend.dto.NoticeDTO;
import com.paytus.backend.service.NoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class InsertNotice {

    @Autowired
    NoticeService service;

    @Test
    void contextLoads() throws Exception {

            NoticeDTO notice = new NoticeDTO(0,"admin04", "공지4", "a", null,"a");
            service.register(notice);
            System.out.println("ok");
            System.out.println(notice);
    }

}
