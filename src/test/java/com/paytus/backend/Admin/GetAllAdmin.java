package com.paytus.backend.Admin;

import com.paytus.backend.dto.AdminDTO;
import com.paytus.backend.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GetAllAdmin {

    @Autowired
    AdminService service;

    @Test
    void contextLoads() throws Exception {

        List<AdminDTO> list = null;
        list = service.get();
        System.out.println("ok");

        for(AdminDTO a:list){
            System.out.println(a);
        }


    }

}
