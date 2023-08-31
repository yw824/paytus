package com.paytus.backend.mapper;

import com.paytus.backend.dto.DataDTO;
import com.paytus.backend.dto.FaqDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FaqMapper {
    public void insert(FaqDTO faqDTO) throws Exception;

    public void delete(Integer integer) throws Exception;

    public void update(FaqDTO faqDTO) throws Exception;

    public FaqDTO select(Integer integer) throws Exception;

    public List<FaqDTO> selectAll() throws Exception;
}
