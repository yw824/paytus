package com.paytus.backend.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NoticeDTO {

    private int noticeseq;
    private String adminid;
    private String noticetitle;
    private String noticetext;
    private Date noticedate;
    private String noticeurl;


}
