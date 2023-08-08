package com.paytus.backend.mapper;

import com.paytus.backend.dto.AdminDTO;
import com.paytus.backend.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminMapper extends MyMapper<String, AdminDTO> {

}
