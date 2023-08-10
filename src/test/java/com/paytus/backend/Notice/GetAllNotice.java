package com.paytus.backend.Notice;

import com.paytus.backend.dto.NoticeDTO;
import com.paytus.backend.service.NoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GetAllNotice {

    @Autowired
    NoticeService service;

    @Test
    void contextLoads() throws Exception {

        List<NoticeDTO> list = null;
        list = service.get();
        System.out.println("ok");

        for(NoticeDTO a:list){
            System.out.println(a);
        }


    }

}
