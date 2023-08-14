package com.paytus.backend.service;

import com.paytus.backend.dto.NoticeDTO;
import com.paytus.backend.frame.MyService;
import com.paytus.backend.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService implements MyService<Integer, NoticeDTO> {

    @Autowired
    NoticeMapper mapper;


    @Override
    public void register(NoticeDTO noticeDTO) throws Exception {
        mapper.insert(noticeDTO);
    }

    @Override
    public void remove(Integer integer) throws Exception {
        mapper.delete(integer);
    }

    @Override
    public void modify(NoticeDTO noticeDTO) throws Exception {
        mapper.update(noticeDTO);
    }

    @Override
    public NoticeDTO get(Integer integer) throws Exception {
        return mapper.select(integer);
    }

    @Override
    public List<NoticeDTO> get() throws Exception {
        return mapper.selectAll();
    }
}
