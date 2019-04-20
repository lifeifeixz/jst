package com.example.jst.bean;

import java.util.Date;

public class MesBatchRest {
    private int id;
    private int batchId;
    private String restStartTime;
    private String createby;
    private Date createTime;
    private String updateby;
    private Date updateTime;
    private String restEndTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getRestStartTime() {
        return restStartTime;
    }

    public void setRestStartTime(String restStartTime) {
        this.restStartTime = restStartTime;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRestEndTime() {
        return restEndTime;
    }

    public void setRestEndTime(String restEndTime) {
        this.restEndTime = restEndTime;
    }
}
