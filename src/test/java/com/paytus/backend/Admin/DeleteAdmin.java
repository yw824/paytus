package com.paytus.backend.Admin;

import com.paytus.backend.dto.AdminDTO;
import com.paytus.backend.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeleteAdmin {

    @Autowired
    AdminService service;

    @Test
    void contextLoads() throws Exception {

            service.remove(2);
            System.out.println("ok");

    }

}
