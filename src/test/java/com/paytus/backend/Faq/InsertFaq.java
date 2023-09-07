package com.paytus.backend.Faq;
import com.paytus.backend.dto.FaqDTO;
import com.paytus.backend.service.FaqService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class InsertFaq {
    @Autowired
    FaqService service;
    @Test
    void contextLoads() throws Exception {
        FaqDTO faq = new FaqDTO(0,"a","a","a","a","a","a",null,1 ,1);
        //service.register(faq);
        System.out.println("ok");
        System.out.println(faq);
    }
}