package com.paytus.backend.Data;

import com.paytus.backend.dto.DataDTO;
import com.paytus.backend.service.DataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UpdateData {

    @Autowired
    DataService service;

    @Test
    void contextLoads() throws Exception {

            DataDTO data = new DataDTO(2,"abcd", "ab", "ab", null,null);
            service.modify(data);
            System.out.println("ok");
    }

}
