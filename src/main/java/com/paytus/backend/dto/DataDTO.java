package com.paytus.backend.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DataDTO {

    private int dataseq;
    private String adminid;
    private String datatitle;
    private String datalink;
    private String datadate;
}
