package com.example.jst.controller;

import com.example.jst.service.MesWorkTimeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MesWorkTimeController {

    @Autowired
    private MesWorkTimeRecordService workTimeRecordService;

    @RequestMapping("/test")
    public void test(){
        workTimeRecordService.list();
    }
}
