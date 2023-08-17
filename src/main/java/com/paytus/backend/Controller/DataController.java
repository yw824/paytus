package com.paytus.backend.Controller;

import com.paytus.backend.dto.DataDTO;
import com.paytus.backend.model.response.CommonResult;
import com.paytus.backend.model.response.ListResult;
import com.paytus.backend.model.response.SingleResult;
import com.paytus.backend.service.DataService;
import com.paytus.backend.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Data API"})
@RestController
@RequestMapping("/api/data")
public class DataController {
    private DataService service;
    private final ResponseService responseService;
    public DataController(DataService service, ResponseService responseService){
        this.service = service;
        this.responseService = responseService;
    }

    @ApiOperation(value = "자료실 게시글 전체 조회 api" ,notes = "자료실 전체 게시글을 조회합니다.")
    @GetMapping("")
    public ListResult<DataDTO> getAllData() throws Exception {
        return responseService.getListResult(service.get());
    }

    @ApiOperation(value = "자료실 특정 게시글 조회 api" ,notes = "해당 번호의 게시글을 조회합니다.")
    @GetMapping("/{dataseq}")
    public SingleResult<DataDTO> getData(@PathVariable("dataseq") int dataseq) throws Exception {
        return responseService.getSingleResult(service.get(dataseq));
    }

    @ApiOperation(value = "자료실 게시글 생성 api" ,notes = "dataseq=0을 넣으면 자동으로 번호가 생성되고 자료실의 글을 생성합니다.")
    @PostMapping("")
    public SingleResult<DataDTO> registerData(@RequestBody DataDTO dataDTO) throws Exception {
        if (dataDTO.getDataseq()==0){
            service.register(dataDTO);
            return responseService.getSingleResult(dataDTO);
        }
        else
            return responseService.getFailSingleResult();

    }

    @ApiOperation(value = "자료실 게시글 수정 api" ,notes = "해당 번호의 게시글을 수정합니다.")
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

    @ApiOperation(value = "자료실 게시글 삭제 api" ,notes = "해당 번호의 게시글을 삭제합니다.")
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