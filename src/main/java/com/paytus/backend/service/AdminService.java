package com.paytus.backend.service;

import com.paytus.backend.dto.AdminDTO;
import com.paytus.backend.frame.MyService;
import com.paytus.backend.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements MyService<Integer, AdminDTO> {

    @Autowired
    AdminMapper mapper;

    @Override
    public void register(AdminDTO adminDTO) throws Exception {
        mapper.insert(adminDTO);

    }

    @Override
    public void remove(Integer integer) throws Exception {
        mapper.delete(integer);
    }

    @Override
    public void modify(AdminDTO adminDTO) throws Exception {
        mapper.update(adminDTO);
    }

    @Override
    public AdminDTO get(Integer integer) throws Exception {
        return mapper.select(integer);
    }

    @Override
    public List<AdminDTO> get() throws Exception {
        return mapper.selectAll();
    }
}
