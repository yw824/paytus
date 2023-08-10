package com.paytus.backend.Notice;

import com.paytus.backend.service.NoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeleteNotice {

    @Autowired
    NoticeService service;

    @Test
    void contextLoads() throws Exception {

            service.remove(202);
            System.out.println("ok");

    }

}
