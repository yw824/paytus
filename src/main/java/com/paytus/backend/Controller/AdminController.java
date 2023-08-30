package com.paytus.backend.Controller;


import com.paytus.backend.dto.AdminDTO;
import com.paytus.backend.model.response.CommonResult;
import com.paytus.backend.model.response.ListResult;
import com.paytus.backend.model.response.SingleResult;
import com.paytus.backend.service.AdminService;
import com.paytus.backend.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Admin API"})
    @RestController
    @RequestMapping("/api/admin")
    public class AdminController {


        private AdminService service;

        private final ResponseService responseService;

    public AdminController(AdminService service, ResponseService responseService){
        this.service = service;
        this.responseService = responseService;
    }

    @ApiOperation(value = "관리자 전체조회 api" ,notes = "전체 관리자 명단을 조회합니다.")
    @GetMapping("")
    public ListResult<AdminDTO> getAllAdmin(){
        try {
            return responseService.getListResult(service.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @ApiOperation(value = "특정 관리자 조회 api" ,notes = "해당 adminid의 관리자를 조회합니다.")
    @GetMapping("/{adminid}")
    public SingleResult<AdminDTO> getAdmin(@PathVariable("adminid") String adminid){
        try {
            return responseService.getSingleResult(service.get(adminid));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @ApiOperation(value = "관리자 계정 생성 api" ,notes = "객체에 담겨있는 adminid를 가진 관리자 계정을 생성합니다.")
    @PostMapping("")
    public SingleResult<AdminDTO> registerAdmin(@RequestBody AdminDTO adminDTO){
        try {
            if (service.get(adminDTO.getAdminid())==null){
                service.register(adminDTO);
                return responseService.getSingleResult(adminDTO);
            }
            else
                return responseService.getFailSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // @RequestBody: HTTP 요청의 바디내용을 통째로 자바객체로 변환해서 매핑된 메소드 파라미터로 전달해준다.

    @ApiOperation(value = "관리자 계정 정보 수정 api" ,notes = "해당 adminid를 가진 관리자의 계정 정보를 수정합니다.")
    @PutMapping("/{adminid}")
    public SingleResult<AdminDTO> modifyAdmin(@PathVariable("adminid") String adminid, @RequestBody AdminDTO adminDTO){
        if (getAdmin(adminid).getData()!=null){
            adminDTO.setAdminid(adminid);
            try {
                service.modify(adminDTO);
                return responseService.getSingleResult(adminDTO);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else
            return responseService.getFailSingleResult();
    }

    @ApiOperation(value = "관리자 계정 삭제 api" ,notes = "해당 adminid를 가진 관리자 계정을 삭제합니다.")
    @DeleteMapping("/{adminid}")
    public CommonResult removeAdmin(@PathVariable("adminid") String adminid){
        if (getAdmin(adminid).getData()!=null){
            try {
                service.remove(adminid);
                return responseService.getSuccessResult();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        else
            return responseService.getFailResult();
    }


}