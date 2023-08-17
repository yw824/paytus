package com.paytus.backend.Controller;

import com.paytus.backend.dto.FaqDTO;
import com.paytus.backend.service.FaqService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/faq")
public class FaqController {


    private FaqService service;

    public FaqController(FaqService service){
        this.service = service;
    }

    @GetMapping("")
    public List<FaqDTO> getAllFaq() throws Exception {
        return service.get();
    }

    @GetMapping("/{faqseq}")
    public FaqDTO getFaq(@PathVariable("faqseq") int faqseq) throws Exception {
        return service.get(faqseq);
    }

    @PostMapping("")
    public List<FaqDTO> registerFaq(@RequestBody FaqDTO faqDTO) throws Exception {
        service.register(faqDTO);
        return service.get();

        //System.out.println(faqDTO);
    }
    // @RequestBody: HTTP 요청의 바디내용을 통째로 자바객체로 변환해서 매핑된 메소드 파라미터로 전달해준다.

    @PutMapping("/{faqseq}")
    public void modifyFaq(@PathVariable("faqseq") int faqseq, @RequestBody FaqDTO faqDTO) throws Exception {
        faqDTO.setFaqseq(faqseq);
        service.modify(faqDTO);
    }

    @DeleteMapping("/{faqseq}")
    public void removeFaq(@PathVariable("faqseq") int faqseq) throws Exception {
        service.remove(faqseq);
    }


}
