package com.paytus.backend.service;

import com.paytus.backend.dto.AdminDTO;
import com.paytus.backend.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminMapper mapper;


    public void register(AdminDTO adminDTO) throws Exception {
        mapper.insert(adminDTO);

    }


    public void remove(String string) throws Exception {
        mapper.delete(string);
    }


    public void modify(AdminDTO adminDTO) throws Exception {
        mapper.update(adminDTO);
    }


    public AdminDTO get(String string) throws Exception {
        return mapper.select(string);
    }


    public List<AdminDTO> get() throws Exception {
        return mapper.selectAll();
    }
}
