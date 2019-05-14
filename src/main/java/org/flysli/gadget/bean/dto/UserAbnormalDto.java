package org.flysli.gadget.bean.dto;

import org.flysli.gadget.bean.MesAbnormalTime;
import org.flysli.gadget.bean.SysUser;

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
