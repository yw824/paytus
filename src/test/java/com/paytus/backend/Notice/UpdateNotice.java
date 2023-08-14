package com.paytus.backend.Notice;

import com.paytus.backend.dto.NoticeDTO;
import com.paytus.backend.service.NoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;

@SpringBootTest
public class UpdateNotice {

    @Autowired
    NoticeService service;

    @Test
    void contextLoads() throws Exception {

            NoticeDTO notice = new NoticeDTO(202, "admin00","공지00", "a",  null,"a");
            service.modify(notice);
            System.out.println("ok");
    }

}
