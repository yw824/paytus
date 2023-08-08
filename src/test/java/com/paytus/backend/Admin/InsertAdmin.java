package com.paytus.backend.Admin;

import com.paytus.backend.dto.AdminDTO;
import com.paytus.backend.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InsertAdmin {

    @Autowired
    AdminService service;

    @Test
    void contextLoads() throws Exception {

            AdminDTO admin = new AdminDTO("admin04", "pwd04", "a", "a", "a", "a");
            service.register(admin);
            System.out.println("ok");
            System.out.println(admin);
    }

}
