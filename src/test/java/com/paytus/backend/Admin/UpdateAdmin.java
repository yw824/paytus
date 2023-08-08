package com.paytus.backend.Admin;

import com.paytus.backend.dto.AdminDTO;
import com.paytus.backend.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UpdateAdmin {

    @Autowired
    AdminService service;

    @Test
    void contextLoads() throws Exception {

            AdminDTO admin = new AdminDTO("a3", "a3", "a", "a", "a", "a");
            service.modify(admin);
            System.out.println("ok");
    }

}
