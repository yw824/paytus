package com.paytus.backend.Faq;
import com.paytus.backend.dto.FaqDTO;
import com.paytus.backend.service.FaqService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
@SpringBootTest
public class GetAllFaq {
    @Autowired
    FaqService service;
    @Test
    void contextLoads() throws Exception {
        List<FaqDTO> list = null;
        list = service.get();
        System.out.println("ok");
        for(FaqDTO a:list){
            System.out.println(a);
        }
    }
}