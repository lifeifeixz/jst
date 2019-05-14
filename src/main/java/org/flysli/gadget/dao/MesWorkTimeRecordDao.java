package org.flysli.gadget.dao;

import org.flysli.gadget.bean.MesWorkTimeRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MesWorkTimeRecordDao {


    /**
     * 获取上工记录
     *
     * @return
     */
    @Select("SELECT workNo,moduleNO,batchid,userName,startTime,endTime,(UNIX_TIMESTAMP(endTime)-UNIX_TIMESTAMP(startTime))workTime FROM mes_worktime_record WHERE startTime>='2019-04-20 08:00:00' AND endTime<='2019-04-21 08:00:00' ORDER BY workNo,moduleNo")
    List<MesWorkTimeRecord> workTimeRecordList();
}
