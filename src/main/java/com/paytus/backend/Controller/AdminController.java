package com.paytus.backend.Controller;


import com.paytus.backend.dto.AdminDTO;
import com.paytus.backend.model.response.CommonResult;
import com.paytus.backend.model.response.ListResult;
import com.paytus.backend.model.response.SingleResult;
import com.paytus.backend.service.AdminService;
import com.paytus.backend.service.ResponseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {


    private AdminService service;

    private final ResponseService responseService;

    public AdminController(AdminService service, ResponseService responseService){
        this.service = service;
        this.responseService = responseService;
    }

    @GetMapping("")
    public ListResult<AdminDTO> getAllAdmin() throws Exception {
        return responseService.getListResult(service.get());
    }

    @GetMapping("/{adminid}")
    public SingleResult<AdminDTO> getAdmin(@PathVariable("adminid") String adminid) throws Exception {
        return responseService.getSingleResult(service.get(adminid));
    }

    @PostMapping("")
    public SingleResult<AdminDTO> registerAdmin(@RequestBody AdminDTO adminDTO) throws Exception {
        if (service.get(adminDTO.getAdminid())==null){
            service.register(adminDTO);
            return responseService.getSingleResult(adminDTO);
        }
        else
            return responseService.getFailSingleResult();
    }
    // @RequestBody: HTTP 요청의 바디내용을 통째로 자바객체로 변환해서 매핑된 메소드 파라미터로 전달해준다.

    @PutMapping("/{adminid}")
    public SingleResult<AdminDTO> modifyAdmin(@PathVariable("adminid") String adminid, @RequestBody AdminDTO adminDTO) throws Exception {
        if (getAdmin(adminid).getData()!=null){
            adminDTO.setAdminid(adminid);
            service.modify(adminDTO);

            return responseService.getSingleResult(adminDTO);
        }
        else
            return responseService.getFailSingleResult();
    }

    @DeleteMapping("/{adminid}")
    public CommonResult removeAdmin(@PathVariable("adminid") String adminid) throws Exception {
        if (getAdmin(adminid).getData()!=null){
            service.remove(adminid);
            return responseService.getSuccessResult();

        }
        else
            return responseService.getFailResult();
    }


}