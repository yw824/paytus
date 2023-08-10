package com.paytus.backend.Faq;
import com.paytus.backend.service.FaqService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class DeleteFaq {
    @Autowired
    FaqService service;
    @Test
    void contextLoads() throws Exception {
        service.remove(102);
        System.out.println("ok");
    }
}