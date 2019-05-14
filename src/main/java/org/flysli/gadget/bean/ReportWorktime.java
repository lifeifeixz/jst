package org.flysli.gadget.bean;

import java.util.Date;

public class ReportWorktime {
    private int id;
    private String workNo;
    private String modNo;
    private Date createTime;
    private Long work_effective_hour;
    private String userName;
    private Long abnormal_hour;
    private Long rest_effctive_hour;
    private Long rest_hour;


    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModNo() {
        return modNo;
    }

    public void setModNo(String modNo) {
        this.modNo = modNo;
    }

    public Long getWork_effective_hour() {
        return work_effective_hour;
    }

    public void setWork_effective_hour(Long work_effective_hour) {
        this.work_effective_hour = work_effective_hour;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getAbnormal_hour() {
        return abnormal_hour;
    }

    public void setAbnormal_hour(Long abnormal_hour) {
        this.abnormal_hour = abnormal_hour;
    }

    public Long getRest_effctive_hour() {
        return rest_effctive_hour;
    }

    public void setRest_effctive_hour(Long rest_effctive_hour) {
        this.rest_effctive_hour = rest_effctive_hour;
    }

    public Long getRest_hour() {
        return rest_hour;
    }

    public void setRest_hour(Long rest_hour) {
        this.rest_hour = rest_hour;
    }
}
