package com.example.jst.controller;

import com.example.jst.bean.MesWorkTimeRecord;
import com.example.jst.bean.dto.UserAbnormalDto;
import com.example.jst.dao.MesAbnormalTimeDao;
import com.example.jst.service.MesWorkTimeRecordService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MesWorkTimeController {

    @Autowired
    private MesWorkTimeRecordService workTimeRecordService;

    @Autowired
    private MesAbnormalTimeDao abnormalTimeDao;

    @RequestMapping("/test")
    public void test(){
        workTimeRecordService.list();
    }

    @GetMapping("/data")
    public PageInfo<MesWorkTimeRecord> data(){
        return workTimeRecordService.data();
    }

    @RequestMapping("/relationTest")
    public UserAbnormalDto relationTest(){
        return abnormalTimeDao.findByUserName("JST4638");
    }
}
