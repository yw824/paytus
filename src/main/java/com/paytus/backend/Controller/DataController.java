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
    public ListResult<DataDTO> getAllData(){
        try {
            return responseService.getListResult(service.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @ApiOperation(value = "자료실 특정 게시글 조회 api" ,notes = "해당 번호의 게시글을 조회합니다.")
    @GetMapping("/{dataseq}")
    public SingleResult<DataDTO> getData(@PathVariable("dataseq") int dataseq){
        try {
            return responseService.getSingleResult(service.get(dataseq));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @ApiOperation(value = "자료실 게시글 생성 api" ,notes = "dataseq=0을 넣으면 자동으로 번호가 생성되고 자료실의 글을 생성합니다.")
    @PostMapping("")
    public SingleResult<DataDTO> registerData(@RequestPart(value = "dto",required = false) DataDTO dataDTO, @RequestPart(value = "file",required = false) MultipartFile multipartfile){
        // multipartfile 객체에서 getOriginalFilename() 메서드를 호출하여 확장자가 포함된 파일명을 추출
        String dataname = multipartfile.getOriginalFilename();

        // 확장자가 포함된 파일명을 datatitle 칼럼에 추가
        dataDTO.setDatatitle(dataname);

        // dataseq는 autoincrement가 걸려있으므로 insert시 0이어야 dataseq가 자동 증가
        if (dataDTO.getDataseq()==0){
            try {
                FileService.saveFile(multipartfile, datadir);
                service.register(dataDTO);
                return responseService.getSingleResult(dataDTO);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else
            return responseService.getFailSingleResult();

    }

    @ApiOperation(value = "자료실 게시글 수정 api" ,notes = "해당 번호의 게시글을 수정합니다.")
    @PutMapping("/{dataseq}")
    public SingleResult<DataDTO> modifyData(@PathVariable("dataseq") int dataseq, @RequestBody DataDTO dataDTO){
        if (getData(dataseq).getData()!=null){
            dataDTO.setDataseq(dataseq);
            try {
                service.modify(dataDTO);
                return responseService.getSingleResult(dataDTO);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        else
            return responseService.getFailSingleResult();
    }

    @ApiOperation(value = "자료실 게시글 삭제 api" ,notes = "해당 번호의 게시글을 삭제합니다.")
    @DeleteMapping("/{dataseq}")
    public CommonResult removeData(@PathVariable("dataseq") int dataseq){
        if (getData(dataseq).getData()!=null){
            try {
                service.remove(dataseq);
                return responseService.getSuccessResult();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else
            return responseService.getFailResult();
    }

    @ApiOperation(value = "자료실 첨부 파일 다운로드 api" ,notes = "해당 게시글의 첨부 파일을 다운로드 합니다.")
        @GetMapping("/download/{dataseq}")
        public SingleResult<DataDTO> downloadData(HttpServletResponse response, @PathVariable("dataseq") int dataseq){

            DataDTO dto = null;
            try {
                // 파일명이 중복이더라도 정확히 해당 업로드 파일을 찾기 위해
                // 파라미터로 넘어온 dataseq와 일치하는 파일 데이터를 찾아서 dto에 저장
                dto = service.get(dataseq);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            String filename = dto.getDatatitle();

            // File 클래스 객체를 만들고 pathname을 설정
            File file = new File(datadir+filename);
            System.out.println("download file: "+file);

            // FileInputStream: 파일에 바이트 단위로 입력할 수 있도록 하기 위해서 자바에서 제공하는 클래스
            FileInputStream fis = null;
            // BufferedInputStream: InputStream 객체를 인수로 받아 그 객체를 처리할 때 버퍼가 사용되는 스트림을 생성하는 클래스
            BufferedInputStream bis = null;
            // ServletOutputStream: 바이트 기반 출력 스트림의 최상위 클래스인 OutputStream을 상속받아 만들어진 출력 스트림 클래스
            // 브라우저에 출력할 때에는 ServletOutputStream을 사용해야 함.
            ServletOutputStream sos = null;

        try {
            // File 객체가 가리키는 파일을 바이트 스트림으로 읽기 위해 FileInputStream 객체를 생성
            fis = new FileInputStream(file);

            // bis 객체는 내부에 데이터를 임시 저장할 바이트 배열이 내장되어 있음
            // 데이터를 읽어들일 때 최대한 크기만큼 읽어 들이기 때문에, 읽어 들이는 횟수를 줄여서 읽기 속도가 향상
            bis = new BufferedInputStream(fis);

            // ServletOutputStream은 추상클래스이기 때문에 인스턴스를 생성할 수 없다.
            // ServletResponse 클래스의 getOutputStream()이라는 함수를 통해 servletOutputStream 인스턴스를 받아서 사용해야한다.
            sos = response.getOutputStream();

            String reFilename = "";

//// 브라우저 별 한글 인코딩
//            String name = "파일이름";
//            String header = request.getHeader("User-Agent");
//            if (header.contains("Edge")){
//                name = URLEncoder.encode(title, "UTF-8").replaceAll("\\+", "%20");
//                response.setHeader("Content-Disposition", "attachment;filename=\"" + name + "\".xls;");
//            } else if (header.contains("MSIE") || header.contains("Trident")) { // IE 11버전부터 Trident로 변경되었기때문에 추가해준다.
//                name = URLEncoder.encode(title, "UTF-8").replaceAll("\\+", "%20");
//                response.setHeader("Content-Disposition", "attachment;filename=" + name + ".xls;");
//            } else if (header.contains("Chrome")) {
//                name = new String(title.getBytes("UTF-8"), "ISO-8859-1");
//                response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\".xls");
//            } else if (header.contains("Opera")) {
//                name = new String(title.getBytes("UTF-8"), "ISO-8859-1");
//                response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\".xls");
//            } else if (header.contains("Firefox")) {
//                name = new String(title.getBytes("UTF-8"), "ISO-8859-1");
//                response.setHeader("Content-Disposition", "attachment; filename=" + name + ".xls");
//            }

            // 파일명을 UTF-8 인코딩 형태의 바이트로 받아서 ISO-8859-1로 문자를 생성, 다만 브라우저별로 테스트 했을때 오류발생하며 위 코드를 적용해야 함.
            reFilename = new String(filename.getBytes("utf-8"), "ISO-8859-1");

            // 파일유형 설정
            response.setContentType("application/octet-stream;charset=utf-8");
            // 데이터형식 설정 (attachment: 첨부파일)
            response.addHeader("Content-Disposition", "attachment;filename=\"" + reFilename + "\"");
            // 파일길이 설정
            response.setContentLength((int) file.length());

            int read = 0;

            // int read(): FileInputStream의 메소드이며, 1byte씩 내용을 읽어 정수로 반환
            // 버퍼에서 1바이트씩 읽어 들인 후 정수로 반환하여 read에 저장
            while ((read = bis.read()) != -1) {
                // 바이트 단위로 입력받은 내용을 파일에 기록
                sos.write(read); // sos.write(쓰고자하는 데이터의 버퍼);
            }
            System.out.println("download success");

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}