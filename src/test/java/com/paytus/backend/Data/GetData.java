package com.paytus.backend.Data;

import com.paytus.backend.dto.DataDTO;
import com.paytus.backend.service.DataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetData {

    @Autowired
    DataService service;

    @Test
    void contextLoads() throws Exception {

            DataDTO data = null;
            data = service.get(1);
            System.out.println("ok");
            System.out.println(data);

    }

}
