package com.paytus.backend.Controller;


import com.paytus.backend.dto.NoticeDTO;
import com.paytus.backend.model.response.CommonResult;
import com.paytus.backend.model.response.ListResult;
import com.paytus.backend.model.response.SingleResult;
import com.paytus.backend.service.NoticeService;
import com.paytus.backend.service.ResponseService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/notice")
public class NoticeController {
    private NoticeService service;

    private final ResponseService responseService;
    public NoticeController(NoticeService service, ResponseService responseService){
        this.service = service;
        this.responseService = responseService;
    }
    @GetMapping("")
    public ListResult<NoticeDTO> getAllNotice() throws Exception {
        return responseService.getListResult(service.get());
    }
    @GetMapping("/{noticeseq}")
    public SingleResult<NoticeDTO> getNotice(@PathVariable("Noticeseq") int noticeseq) throws Exception {
        return responseService.getSingleResult(service.get(noticeseq));
    }
    @PostMapping("")
    public SingleResult<NoticeDTO> registerNotice(@RequestBody NoticeDTO noticeDTO) throws Exception {
        if (noticeDTO.getNoticeseq()==0){
            service.register(noticeDTO);
            return responseService.getSingleResult(noticeDTO);
        }
        else
            return responseService.getFailSingleResult();

    }
    @PutMapping("/{noticeseq}")
    public SingleResult<NoticeDTO> modifyNotice(@PathVariable("noticeseq") int noticeseq, @RequestBody NoticeDTO noticeDTO) throws Exception {
        if (getNotice(noticeseq).getData()!=null){
            noticeDTO.setNoticeseq(noticeseq);
            service.modify(noticeDTO);

            return responseService.getSingleResult(noticeDTO);
        }
        else
            return responseService.getFailSingleResult();
    }
    @DeleteMapping("/{noticeseq}")
    public CommonResult removeNotice(@PathVariable("noticeseq") int noticeseq) throws Exception {
        if (getNotice(noticeseq).getData()!=null){
            service.remove(noticeseq);
            return responseService.getSuccessResult();
        }
        else
            return responseService.getFailResult();
    }
}