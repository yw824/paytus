package com.paytus.backend.mapper;

import com.paytus.backend.dto.DataDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DataMapper  {
    public void insert(DataDTO dataDTO) throws Exception;

    public void delete(Integer integer) throws Exception;

    public void update(DataDTO dataDTO) throws Exception;

    public DataDTO select(Integer integer) throws Exception;

    public List<DataDTO> selectAll() throws Exception;

}
