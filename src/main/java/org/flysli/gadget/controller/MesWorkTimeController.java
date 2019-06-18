package org.flysli.gadget.controller;

import com.github.pagehelper.PageInfo;
import org.flysli.gadget.bean.MesWorkTimeRecord;
import org.flysli.gadget.service.MesWorkTimeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MesWorkTimeController {
    @Autowired
    private MesWorkTimeRecordService workTimeRecordService;


    @GetMapping("/data")
    public PageInfo<MesWorkTimeRecord> data(){
        return workTimeRecordService.data();
    }

}
