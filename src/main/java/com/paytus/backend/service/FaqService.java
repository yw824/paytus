package com.paytus.backend.service;

import com.paytus.backend.dto.FaqDTO;
import com.paytus.backend.dto.NoticeDTO;
import com.paytus.backend.frame.MyService;
import com.paytus.backend.mapper.FaqMapper;
import com.paytus.backend.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqService implements MyService<Integer, FaqDTO> {

    @Autowired
    FaqMapper mapper;


    @Override
    public void register(FaqDTO faqDTO) throws Exception {
        mapper.insert(faqDTO);
    }


    @Override
    public void remove(Integer integer) throws Exception {
        mapper.delete(integer);
    }

    @Override
    public void modify(FaqDTO faqDTO) throws Exception {
        mapper.update(faqDTO);
    }

    @Override
    public FaqDTO get(Integer integer) throws Exception {
        return mapper.select(integer);
    }

    @Override
    public List<FaqDTO> get() throws Exception {
        return mapper.selectAll();
    }
}
