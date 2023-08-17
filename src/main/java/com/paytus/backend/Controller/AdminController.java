package com.paytus.backend.Controller;
import com.paytus.backend.dto.AdminDTO;
import com.paytus.backend.service.AdminService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {


    private AdminService service;

    public AdminController(AdminService service){
        this.service = service;
    }

    @GetMapping("")
    public List<AdminDTO> getAllAdmin() throws Exception {
        return service.get();
    }

    @GetMapping("/{adminid}")
    public AdminDTO getAdmin(@PathVariable("adminid") String adminid) throws Exception {
        return service.get(adminid);
    }

    @PostMapping("")
    public void registerAdmin(@RequestBody AdminDTO adminDTO) throws Exception {
        service.register(adminDTO);
        //System.out.println(adminDTO);
    }
    // @RequestBody: HTTP 요청의 바디내용을 통째로 자바객체로 변환해서 매핑된 메소드 파라미터로 전달해준다.

    @PutMapping("/{adminid}")
    public void modifyAdmin(@PathVariable("adminid") String adminid, @RequestBody AdminDTO adminDTO) throws Exception {
        adminDTO.setAdminid(adminid);
        service.modify(adminDTO);
    }

    @DeleteMapping("/{adminid}")
    public void removeAdmin(@PathVariable("adminid") String adminid) throws Exception {
        service.remove(adminid);
    }


}
