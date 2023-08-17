package com.paytus.backend.Controller;

import com.paytus.backend.dto.FaqDTO;
import com.paytus.backend.model.response.CommonResult;
import com.paytus.backend.model.response.ListResult;
import com.paytus.backend.model.response.SingleResult;
import com.paytus.backend.service.FaqService;
import com.paytus.backend.service.ResponseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/faq")
public class FaqController {


    private FaqService service;
    private final ResponseService responseService;

    public FaqController(FaqService service, ResponseService responseService){
        this.service = service;
        this.responseService = responseService;
    }

    @GetMapping("")
    public ListResult<FaqDTO> getAllFaq() throws Exception {
        return responseService.getListResult(service.get());
    }

    @GetMapping("/{faqseq}")
    public SingleResult<FaqDTO> getFaq(@PathVariable("faqseq") int faqseq) throws Exception {
        return responseService.getSingleResult(service.get(faqseq));
    }

    @PostMapping("")
    public SingleResult<FaqDTO> registerFaq(@RequestBody FaqDTO faqDTO) throws Exception {
        if (faqDTO.getFaqseq()==0){
            service.register(faqDTO);
            return responseService.getSingleResult(faqDTO);
        }
        else
            return responseService.getFailSingleResult();

    }
    // @RequestBody: HTTP 요청의 바디내용을 통째로 자바객체로 변환해서 매핑된 메소드 파라미터로 전달해준다.

    @PutMapping("/{faqseq}")
    public SingleResult<FaqDTO> modifyFaq(@PathVariable("faqseq") int faqseq, @RequestBody FaqDTO faqDTO) throws Exception {
        if (getFaq(faqseq).getData()!=null){
            faqDTO.setFaqseq(faqseq);
            service.modify(faqDTO);

            return responseService.getSingleResult(faqDTO);
        }
        else
            return responseService.getFailSingleResult();
    }

    @DeleteMapping("/{faqseq}")
    public CommonResult removeFaq(@PathVariable("faqseq") int faqseq) throws Exception {
        if (getFaq(faqseq).getData()!=null){
            service.remove(faqseq);
            return responseService.getSuccessResult();
        }
        else
            return responseService.getFailResult();
    }


}
