package com.example.jst.dao;

import com.example.jst.bean.MesAbnormalTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MesAbnormalTimeDao {

    @Select("SELECT c.batchid,c.expstartTime,IF(UNIX_TIMESTAMP(c.`expendTime`)>UNIX_TIMESTAMP('2019-04-20 08:00:00'),'2019-04-20 08:00:00',c.`expendTime`)expendTime,c.username FROM (SELECT a.batchid,b.`expstartTime`,IFNULL(b.`expendTime`,'2019-04-20 08:00:00')expendTime,b.`username` \n" +
            "FROM mes_abnormal_record a LEFT JOIN mes_abnormal_time b ON a.abnormalUuid=b.abnormalUuid \n" +
            "WHERE b.expstartTime>='2019-04-19 08:00:00')c WHERE c.userName=#{userName}")
    List<MesAbnormalTime> queryAbnormalTimes(@Param("userName") String userName);
}
