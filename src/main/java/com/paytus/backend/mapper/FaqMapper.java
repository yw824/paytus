package com.paytus.backend.mapper;

import com.paytus.backend.dto.FaqDTO;
import com.paytus.backend.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FaqMapper extends MyMapper<Integer, FaqDTO> {
}
