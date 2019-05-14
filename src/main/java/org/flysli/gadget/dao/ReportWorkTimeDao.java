package org.flysli.gadget.dao;

import org.flysli.gadget.bean.ReportWorktime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ReportWorkTimeDao {

    @Select("insert into `report_worktime` (`createTime`, `workNo`, `modNo`, `work_effective_hour`," +
            " `userName`, `abnormal_hour`, `rest_effctive_hour`, `rest_hour`)" +
            " values(#{createTime},#{workNo},#{modNo},#{work_effective_hour},#{userName},#{abnormal_hour},#{rest_effctive_hour},#{rest_hour})")
    void save(ReportWorktime worktime);
}
