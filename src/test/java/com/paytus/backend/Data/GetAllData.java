package com.paytus.backend.Data;

import com.paytus.backend.dto.DataDTO;
import com.paytus.backend.service.DataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GetAllData {

    @Autowired
    DataService service;

    @Test
    void contextLoads() throws Exception {

        List<DataDTO> list = null;
        list = service.get();
        System.out.println("ok");

        for(DataDTO a:list){
            System.out.println(a);
        }


    }

}
