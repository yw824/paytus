package com.paytus.backend.Controller;

import com.paytus.backend.dto.DataDTO;
import com.paytus.backend.model.response.CommonResult;
import com.paytus.backend.model.response.ListResult;
import com.paytus.backend.model.response.SingleResult;
import com.paytus.backend.service.DataService;
import com.paytus.backend.service.FileService;
import com.paytus.backend.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Api(tags = {"Data API"})
@RestController
@RequestMapping("/api/data")
public class DataController {

    private DataService service;
    private final ResponseService responseService;

    @Value(value = "${datadir}")
    String datadir;

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

        DataDTO dto = service.get(dataseq);

        return responseService.getSingleResult(service.get(dataseq));
    }

    @ApiOperation(value = "자료실 게시글 생성 api" ,notes = "dataseq=0을 넣으면 자동으로 번호가 생성되고 자료실의 글을 생성합니다.")
    @PostMapping("")
    public SingleResult<DataDTO> registerData(@RequestPart(value = "dto",required = false) DataDTO dataDTO, @RequestPart(value = "file",required = false) MultipartFile multipartfile) throws Exception {
        System.out.println("multipartfile: "+ multipartfile); // Blob인 거,,,
        String dataname = multipartfile.getOriginalFilename(); // blob
        System.out.println("dataname: "+dataname);
        System.out.println("datadto: "+dataDTO);
        dataDTO.setDatatitle(dataname);
        System.out.println("datadto: "+dataDTO);

        if (dataDTO.getDataseq()==0){
            FileService.saveFile(multipartfile, datadir);
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

//    @ApiOperation(value = "자료실 첨부 파일 다운로드 api" ,notes = "해당 게시글의 첨부 파일을 다운로드 합니다.")
//    @GetMapping("/download/{dataseq}")
//    public SingleResult<DataDTO> downloadData(HttpServletRequest request, HttpServletResponse response, @PathVariable("dataseq") int dataseq) throws Exception {
//
//        DataDTO dto = null;
//
//        dto = service.get(dataseq);
//        System.out.println("dto: "+dto);
//
//        String filename = dto.getDatatitle();
//        System.out.println("filename: "+filename);
//
//        File file = new File(filepath+filename);
//        System.out.println("file: "+file);
//
//        FileInputStream fis = null;
//        BufferedInputStream bis = null;
//        ServletOutputStream sos = null;
//
//        try {
//
//            fis = new FileInputStream(file);
//            System.out.println("fis: "+fis);
//
//            bis = new BufferedInputStream(fis);
//            System.out.println("bis: "+bis);
//
//            sos = response.getOutputStream();
//
//            String reFilename = "";
//
//            // IE로 실행한 경우인지 판별-> IE는 따로 인코딩 작업을 거쳐야 한다. request헤어에 MSIE 또는 Trident가 포함되어 있는지 확인
//            boolean isMSIE = request.getHeader("user-agent").indexOf("MISE") != -1 || request.getHeader("user-agent").indexOf("Trident") != -1;
//
//            if (isMSIE) {
//                reFilename = URLEncoder.encode(filename, "utf-8");
//                reFilename = reFilename.replaceAll("WW+", "%20");
//
//            } else {
//                reFilename = new String(filename.getBytes("utf-8"), "ISO-8859-1");
//            }
//
//            response.setContentType("application/octet-stream;charset=utf-8");
//            response.addHeader("Content-Disposition", "attachment;filename=\"" + reFilename + "\"");
//            response.setContentLength((int) file.length());
//
//            System.out.println("response"+response);
//            System.out.println("response"+response.getHeader("Content-Disposition"));
//
//            int read = 0;
//            while ((read = bis.read()) != -1) {
//                sos.write(read);
//            }
//
//        } catch (FileNotFoundException e){
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//
//    }

    @ApiOperation(value = "자료실 첨부 파일 다운로드 api" ,notes = "해당 게시글의 첨부 파일을 다운로드 합니다.")
    @GetMapping("/download/{dataseq}")
    public SingleResult<DataDTO> downloadData(HttpServletRequest request, HttpServletResponse response, @PathVariable("dataseq") int dataseq) throws Exception {

        DataDTO dto = null;

        dto = service.get(dataseq);
        System.out.println("dto: "+dto);

        String filename = dto.getDatatitle();
        System.out.println("filename: "+filename);

        File file = new File(datadir+filename);
        System.out.println("file: "+file);

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ServletOutputStream sos = null;

        try {

            fis = new FileInputStream(file);
            System.out.println("fis: "+fis);

            bis = new BufferedInputStream(fis);
            System.out.println("bis: "+bis);

            sos = response.getOutputStream();

            String reFilename = "";

            // IE로 실행한 경우인지 판별-> IE는 따로 인코딩 작업을 거쳐야 한다. request헤어에 MSIE 또는 Trident가 포함되어 있는지 확인
            boolean isMSIE = request.getHeader("user-agent").indexOf("MISE") != -1 || request.getHeader("user-agent").indexOf("Trident") != -1;

            if (isMSIE) {
                reFilename = URLEncoder.encode(filename, "utf-8");
                reFilename = reFilename.replaceAll("WW+", "%20");

            } else {
                reFilename = new String(filename.getBytes("utf-8"), "ISO-8859-1");
            }

            response.setContentType("application/octet-stream;charset=utf-8");
            response.addHeader("Content-Disposition", "attachment;filename=\"" + reFilename + "\"");
            response.setContentLength((int) file.length());

            System.out.println("response"+response);
            System.out.println("response"+response.getHeader("Content-Disposition"));

            int read = 0;
            while ((read = bis.read()) != -1) {
                sos.write(read);
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}