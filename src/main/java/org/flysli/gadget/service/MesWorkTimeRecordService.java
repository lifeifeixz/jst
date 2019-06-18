package org.flysli.gadget.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.flysli.gadget.bean.MesWorkTimeRecord;
import org.flysli.gadget.dao.MesWorkTimeRecordDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MesWorkTimeRecordService {

    @Autowired
    private MesWorkTimeRecordDao workTimeRecordDao;

    public PageInfo<MesWorkTimeRecord> data() {
        PageHelper.startPage(0, 10);
//        PageInfo<MesWorkTimeRecord> pageInfo = new PageInfo<>();
//        pageInfo.setTotal(page.getTotal());
//        pageInfo.setSize(page.getPageSize());
//        pageInfo.setPages(page.getPages());
//        pageInfo.setList(page);
        return new PageInfo<>(workTimeRecordDao.workTimeRecordList());
    }

}
