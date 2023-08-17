package com.paytus.backend.Controller;

import com.paytus.backend.dto.DataDTO;
import com.paytus.backend.dto.FaqDTO;
import com.paytus.backend.model.response.CommonResult;
import com.paytus.backend.model.response.ListResult;
import com.paytus.backend.model.response.SingleResult;
import com.paytus.backend.service.DataService;
import com.paytus.backend.service.ResponseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data")
public class DataController {
    private DataService service;
    private final ResponseService responseService;
    public DataController(DataService service, ResponseService responseService){
        this.service = service;
        this.responseService = responseService;
    }
    @GetMapping("")
    public ListResult<DataDTO> getAllData() throws Exception {
        return responseService.getListResult(service.get());
    }
    @GetMapping("/{dataseq}")
    public SingleResult<DataDTO> getData(@PathVariable("Dataseq") int dataseq) throws Exception {
        return responseService.getSingleResult(service.get(dataseq));
    }

    @PostMapping("")
    public SingleResult<DataDTO> registerData(@RequestBody DataDTO dataDTO) throws Exception {
        if (dataDTO.getDataseq()==0){
            service.register(dataDTO);
            return responseService.getSingleResult(dataDTO);
        }
        else
            return responseService.getFailSingleResult();

    }
    @PutMapping("/{dataseq}")
    public SingleResult<DataDTO> modifyData(@PathVariable("dataseq") int dataseq, @RequestBody DataDTO dataDTO) throws Exception {
        if (getData(dataseq).getData()!=null){
            dataDTO.setDataseq(dataseq);
            service.modify(dataDTO);

            return responseService.getSingleResult(dataDTO);
        }
        else
            return responseService.getFailSingleResult();
    }

    @DeleteMapping("/{dataseq}")
    public CommonResult removeData(@PathVariable("dataseq") int dataseq) throws Exception {
        if (getData(dataseq).getData()!=null){
            service.remove(dataseq);
            return responseService.getSuccessResult();
        }
        else
            return responseService.getFailResult();
    }
}