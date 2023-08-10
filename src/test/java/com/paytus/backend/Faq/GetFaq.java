package com.paytus.backend.Faq;
import com.paytus.backend.dto.FaqDTO;
import com.paytus.backend.service.FaqService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class GetFaq {
    @Autowired
    FaqService service;
    @Test
    void contextLoads() throws Exception {
        FaqDTO faq = null;
        faq = service.get(101);
        System.out.println("ok");
        System.out.println(faq);
    }
}