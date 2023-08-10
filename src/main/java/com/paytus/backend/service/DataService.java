package com.paytus.backend.service;

import com.paytus.backend.dto.DataDTO;
import com.paytus.backend.frame.MyService;
import com.paytus.backend.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService implements MyService<Integer, DataDTO> {

    @Autowired
    DataMapper mapper;

    @Override
    public void register(DataDTO dataDTO) throws Exception {
        mapper.insert(dataDTO);

    }

    @Override
    public void remove(Integer integer) throws Exception {
        mapper.delete(integer);
    }

    @Override
    public void modify(DataDTO dataDTO) throws Exception {
        mapper.update(dataDTO);
    }

    @Override
    public DataDTO get(Integer integer) throws Exception {
        return mapper.select(integer);
    }

    @Override
    public List<DataDTO> get() throws Exception {
        return mapper.selectAll();
    }
}
