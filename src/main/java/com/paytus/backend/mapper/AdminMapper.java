package com.paytus.backend.mapper;

import com.paytus.backend.dto.AdminDTO;
import com.paytus.backend.dto.FaqDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminMapper  {
    public void insert(AdminDTO adminDTO) throws Exception;

    public void delete(String string) throws Exception;

    public void update(AdminDTO adminDTO) throws Exception;

    public AdminDTO select(String string) throws Exception;

    public List<AdminDTO> selectAll() throws Exception;

}
