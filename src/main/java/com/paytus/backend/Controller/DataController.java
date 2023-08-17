package com.paytus.backend.Controller;

import com.paytus.backend.dto.DataDTO;
import com.paytus.backend.service.DataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {


    private DataService service;

    public DataController(DataService service){
        this.service = service;
    }

    @GetMapping("")
    public List<DataDTO> getAllData() throws Exception {
        return service.get();
    }

    @GetMapping("/{dataseq}")
    public DataDTO getData(@PathVariable("Dataseq") int dataseq) throws Exception {
        return service.get(dataseq);
    }

    @PostMapping("")
    public void registerData(@RequestBody DataDTO dataDTO) throws Exception {
        service.register(dataDTO);
        //System.out.println(faqDTO);
    }
    // @RequestBody: HTTP 요청의 바디내용을 통째로 자바객체로 변환해서 매핑된 메소드 파라미터로 전달해준다.

    @PutMapping("/{dataseq}")
    public void modifyFaq(@PathVariable("dataseq") int dataseq, @RequestBody DataDTO dataDTO) throws Exception {
        dataDTO.setDataseq(dataseq);
        service.modify(dataDTO);
    }

    @DeleteMapping("/{dataseq}")
    public void removeData(@PathVariable("dataseq") int dataseq) throws Exception {
        service.remove(dataseq);
    }


}
