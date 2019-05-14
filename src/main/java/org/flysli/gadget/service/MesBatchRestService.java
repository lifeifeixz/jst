package org.flysli.gadget.service;

import org.flysli.gadget.bean.MesBatchRest;
import org.flysli.gadget.bean.dto.RestDate;
import org.flysli.gadget.dao.MesBatchRestDao;
import org.flysli.gadget.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MesBatchRestService {
    @Autowired
    private MesBatchRestDao batchRestDao;

    /**
     * 构造休息时间
     *
     * @param date    上工当天
     * @param batchId 上工的班次ID
     * @return
     */
    public List<RestDate> structRestDate(Date date, Integer batchId) {
        List<MesBatchRest> rests = batchRestDao.queryBatchRest(batchId);
        ArrayList<RestDate> arrayList = new ArrayList<RestDate>();
        for (MesBatchRest r : rests) {

            //当开始时间大于结束时间的时候，认定是跨天休息
            if (DateUtil.conventTimeToStamp(r.getRestStartTime()) >
                    DateUtil.conventTimeToStamp(r.getRestEndTime())) {
                Date startDate = DateUtil.structDate(date, r.getRestStartTime());
                Date endDate = DateUtil.structDate(DateUtil.datePlus(date, 1), r.getRestEndTime());
                arrayList.add(new RestDate(startDate, endDate));
            } else {
                Date startDate = DateUtil.structDate(date, r.getRestStartTime());
                Date endDate = DateUtil.structDate(date, r.getRestEndTime());
                arrayList.add(new RestDate(startDate, endDate));
            }
        }
        return arrayList;
    }
}
