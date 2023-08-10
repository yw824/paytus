package com.paytus.backend.Notice;

import com.paytus.backend.dto.NoticeDTO;
import com.paytus.backend.service.NoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetNotice {

    @Autowired
    NoticeService service;

    @Test
    void contextLoads() throws Exception {

            NoticeDTO notice = null;
            notice = service.get(200);
            System.out.println("ok");
            System.out.println(notice);

    }

}
