package com.paytus.backend.service;

import com.paytus.backend.dto.FaqDTO;
import com.paytus.backend.dto.NoticeDTO;
import com.paytus.backend.mapper.FaqMapper;
import com.paytus.backend.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqService  {

    @Autowired
    FaqMapper mapper;



    public void register(FaqDTO faqDTO) throws Exception {
        mapper.insert(faqDTO);
    }



    public void remove(Integer integer) throws Exception {
        mapper.delete(integer);
    }


    public void modify(FaqDTO faqDTO) throws Exception {
        mapper.update(faqDTO);
    }


    public FaqDTO get(Integer integer) throws Exception {
        return mapper.select(integer);
    }


    public List<FaqDTO> get() throws Exception {
        return mapper.selectAll();
    }
}
