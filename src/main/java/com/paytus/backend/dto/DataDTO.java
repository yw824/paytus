package com.paytus.backend.dto;

import lombok.*;

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
