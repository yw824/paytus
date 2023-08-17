package com.paytus.backend.Controller;

import com.paytus.backend.dto.NoticeDTO;
import com.paytus.backend.service.NoticeService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/notice")
public class NoticeController {


    private NoticeService service;

    public NoticeController(NoticeService service){
        this.service = service;
    }

    @GetMapping("")
    public List<NoticeDTO> getAllNotice() throws Exception {
        return service.get();
    }

    @GetMapping("/{noticeseq}")
    public NoticeDTO getNotice(@PathVariable("noticeseq") int noticeseq) throws Exception {
        return service.get(noticeseq);
    }

    @PostMapping("")
    public void registerNotice(@RequestBody NoticeDTO noticeDTO) throws Exception {
        service.register(noticeDTO);
        //System.out.println(noticeDTO);
    }
    // @RequestBody: HTTP 요청의 바디내용을 통째로 자바객체로 변환해서 매핑된 메소드 파라미터로 전달해준다.

    @PutMapping("/{noticeseq}")
    public void modifyNotice(@PathVariable("noticeseq") int noticeseq, @RequestBody NoticeDTO noticeDTO) throws Exception {
        noticeDTO.setNoticeseq(noticeseq);
        service.modify(noticeDTO);
    }

    @DeleteMapping("/{noticeseq}")
    public void removeNotice(@PathVariable("noticeseq") int noticeseq) throws Exception {
        service.remove(noticeseq);
    }


}
