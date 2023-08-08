package com.paytus.backend.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AdminDTO {

//    private int adminseq;
    private String adminid;
    private String adminpw;
    private String adminname;
    private String admincall;
    private String adminemail;
    private String adminpart;

}
