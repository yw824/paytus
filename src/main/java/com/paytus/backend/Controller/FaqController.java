package com.paytus.backend.Controller;

import com.paytus.backend.dto.FaqDTO;
import com.paytus.backend.model.response.CommonResult;
import com.paytus.backend.model.response.ListResult;
import com.paytus.backend.model.response.SingleResult;
import com.paytus.backend.service.EmailService;
import com.paytus.backend.service.FaqService;
import com.paytus.backend.service.ResponseService;
import com.paytus.backend.service.SlackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Api(tags = {"Faq API"})
@RestController
@RequestMapping("/api/faq")
public class FaqController {


    private FaqService service;
    private final EmailService emailService;
    private final ResponseService responseService;
    private final SlackService slackService;

    public FaqController(FaqService service, EmailService emailService, ResponseService responseService, SlackService slackService){

        this.service = service;
        this.emailService = emailService;
        this.responseService = responseService;
        this.slackService = slackService;
    }


    @ApiOperation(value = "문의 글 전체조회 api" ,notes = "조건없이 문의 전체 글을 조회합니다.")
    @GetMapping("")
    public ListResult<FaqDTO> getAllFaq(){
        try {
            return responseService.getListResult(service.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @ApiOperation(value = "특정 문의 글 조회 api" ,notes = "해당 번호의 문의 글을 조회합니다.")
    @GetMapping("/{faqseq}")
    public SingleResult<FaqDTO> getFaq(@PathVariable("faqseq") int faqseq){
        try {
            return responseService.getSingleResult(service.get(faqseq));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @ApiOperation(value = "문의 글 생성 api" ,notes = "faqseq=0을 넣으면 자동으로 번호가 생성되고 문의 글을 생성합니다.")
    @PostMapping("")
    public SingleResult<FaqDTO> registerFaq(@RequestBody FaqDTO faqDTO){
        if (faqDTO.getFaqseq()==0){
            try {
                service.register(faqDTO);
                slackService.sendSlack(faqDTO);
                emailService.sendMailToAdmin(faqDTO);;

            //slackService.sendSlack(faqDTO);======
                return responseService.getSingleResult(faqDTO);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else
            return responseService.getFailSingleResult();
    }

    // @RequestBody: HTTP 요청의 바디내용을 통째로 자바객체로 변환해서 매핑된 메소드 파라미터로 전달해준다.
    @ApiOperation(value = "문의 글 수정 api" ,notes = "해당 번호의 문의 글을 수정합니다.")
    @PutMapping("/{faqseq}")
    public SingleResult<FaqDTO> modifyFaq(@PathVariable("faqseq") int faqseq, @RequestBody FaqDTO faqDTO){
        if (getFaq(faqseq).getData()!=null){
            faqDTO.setFaqseq(faqseq);
            try {
                service.modify(faqDTO);
                return responseService.getSingleResult(faqDTO);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else
            return responseService.getFailSingleResult();
    }

    @ApiOperation(value = "문의 글 삭제 api" ,notes = "해당 번호의 문의 글을 조회합니다.")
    @DeleteMapping("/{faqseq}")
    public CommonResult removeFaq(@PathVariable("faqseq") int faqseq){
        if (getFaq(faqseq).getData()!=null){
            try {
                service.remove(faqseq);
                return responseService.getSuccessResult();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else
            return responseService.getFailResult();
    }

}