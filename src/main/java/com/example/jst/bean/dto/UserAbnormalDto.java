package com.example.jst.bean.dto;

import com.example.jst.bean.MesAbnormalTime;
import com.example.jst.bean.SysUser;

import java.util.List;

public class UserAbnormalDto extends SysUser {

    private List<MesAbnormalTime> abnormalTimes;


    public List<MesAbnormalTime> getAbnormalTimes() {
        return abnormalTimes;
    }

    public void setAbnormalTimes(List<MesAbnormalTime> abnormalTimes) {
        this.abnormalTimes = abnormalTimes;
    }
}
