package com.example.jst.controller;

import com.example.jst.bean.dto.UserAbnormalDto;
import com.example.jst.dao.MesAbnormalTimeDao;
import com.example.jst.service.MesWorkTimeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/relationTest")
    public UserAbnormalDto relationTest(){
        return abnormalTimeDao.findByUserName("JST4638");
    }
}
