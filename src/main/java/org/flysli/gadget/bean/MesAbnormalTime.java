package org.flysli.gadget.bean;

import java.util.Date;

public class MesAbnormalTime {
    private String id;
    private String abnormalUuid;
    private String userName;
    private int batchid;
    private Date expstartTime;
    private Date expendTime;
    private Date createTime;
    private String createBy;

    public int getBatchid() {
        return batchid;
    }

    public void setBatchid(int batchid) {
        this.batchid = batchid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbnormalUuid() {
        return abnormalUuid;
    }

    public void setAbnormalUuid(String abnormalUuid) {
        this.abnormalUuid = abnormalUuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getExpstartTime() {
        return expstartTime;
    }

    public void setExpstartTime(Date expstartTime) {
        this.expstartTime = expstartTime;
    }

    public Date getExpendTime() {
        return expendTime;
    }

    public void setExpendTime(Date expendTime) {
        this.expendTime = expendTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
