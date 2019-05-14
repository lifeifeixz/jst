package org.flysli.gadget.controller;

import org.flysli.gadget.bean.dto.UserAbnormalDto;
import org.flysli.gadget.dao.MesAbnormalTimeDao;
import org.flysli.gadget.service.MesWorkTimeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Validator;

@RestController
public class MesWorkTimeController {
    @Autowired
    private Validator validator;

    @Autowired
    private MesWorkTimeRecordService workTimeRecordService;

    @Autowired
    private MesAbnormalTimeDao abnormalTimeDao;

    @RequestMapping("/test")
    public void test() {
        workTimeRecordService.list();
    }

    @RequestMapping("/relationTest")
    public UserAbnormalDto relationTest() {
        return abnormalTimeDao.findByUserName("JST4638");
    }
}
