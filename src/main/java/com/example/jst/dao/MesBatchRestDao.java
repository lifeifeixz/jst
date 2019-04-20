package com.example.jst.dao;

import com.example.jst.bean.MesBatchRest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MesBatchRestDao {

    @Select("SELECT * FROM mes_batch_rest WHERE batchId=#{batchId};")
    List<MesBatchRest> queryBatchRest(@Param("batchId") Integer batchId);
}
