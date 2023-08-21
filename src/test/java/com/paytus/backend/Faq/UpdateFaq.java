package com.paytus.backend.Faq;
import com.paytus.backend.dto.FaqDTO;
import com.paytus.backend.service.FaqService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class UpdateFaq {
    @Autowired
    FaqService service;
    @Test
    void contextLoads() throws Exception {
//        FaqDTO faq = new FaqDTO(102,"admin5","b","b","b","b","b","b",null,0 ,0 ,1 ,"b",null);
//        service.modify(faq);
//        System.out.println("ok");
    }
}