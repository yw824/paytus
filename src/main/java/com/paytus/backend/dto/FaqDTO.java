package com.paytus.backend.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FaqDTO {

    private int faqseq;
    private String faqarea;
    private String faqcorp;
    private String faqname;
    private String faqcall;
    private String faqemail;
    private String faqtext;
    private Date faqdate;
    private int faqterm;
    private int faqisnew;


}
