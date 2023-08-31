package com.paytus.backend.mapper;

import com.paytus.backend.dto.DataDTO;
import com.paytus.backend.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DataMapper extends MyMapper<Integer, DataDTO> {

}
