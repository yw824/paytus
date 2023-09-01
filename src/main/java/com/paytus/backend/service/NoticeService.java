package com.paytus.backend.service;

import com.paytus.backend.dto.NoticeDTO;
import com.paytus.backend.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    NoticeMapper mapper;



    public void register(NoticeDTO noticeDTO) throws Exception {
        mapper.insert(noticeDTO);
    }


    public void remove(Integer integer) throws Exception {
        mapper.delete(integer);
    }


    public void modify(NoticeDTO noticeDTO) throws Exception {
        mapper.update(noticeDTO);
    }


    public NoticeDTO get(Integer integer) throws Exception {
        return mapper.select(integer);
    }


    public List<NoticeDTO> get() throws Exception {
        return mapper.selectAll();
    }
}
