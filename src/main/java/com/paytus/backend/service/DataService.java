package com.paytus.backend.service;

import com.paytus.backend.dto.DataDTO;
import com.paytus.backend.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService  {

    @Autowired
    DataMapper mapper;


    public void register(DataDTO dataDTO) throws Exception {
        mapper.insert(dataDTO);

    }


    public void remove(Integer integer) throws Exception {
        mapper.delete(integer);
    }


    public void modify(DataDTO dataDTO) throws Exception {
        mapper.update(dataDTO);
    }


    public DataDTO get(Integer integer) throws Exception {
        return mapper.select(integer);
    }


    public List<DataDTO> get() throws Exception {
        return mapper.selectAll();
    }
}
