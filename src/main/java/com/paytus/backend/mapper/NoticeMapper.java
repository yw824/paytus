package com.paytus.backend.mapper;

import com.paytus.backend.dto.NoticeDTO;
import com.paytus.backend.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface NoticeMapper extends MyMapper<Integer, NoticeDTO> {
}
