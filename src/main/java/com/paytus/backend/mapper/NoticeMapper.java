package com.paytus.backend.mapper;

import com.paytus.backend.dto.FaqDTO;
import com.paytus.backend.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NoticeMapper {

    public void insert(NoticeDTO noticeDTO) throws Exception;

    public void delete(Integer integer) throws Exception;

    public void update(NoticeDTO noticeDTO) throws Exception;

    public NoticeDTO select(Integer integer) throws Exception;

    public List<NoticeDTO> selectAll() throws Exception;
}
