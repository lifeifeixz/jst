package org.flysli.gadget.service;

import org.flysli.gadget.bean.MesAbnormalTime;
import org.flysli.gadget.bean.MesBatchRest;
import org.flysli.gadget.dao.MesAbnormalTimeDao;
import org.flysli.gadget.dao.MesBatchRestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesAbnormaService {

    @Autowired
    private MesAbnormalTimeDao abnormalTimeDao;

    @Autowired
    private MesBatchRestDao batchRestDao;

    /**
     * 计算有效的异常时间
     *
     * @return
     */
    public Long calcuEffectiveAbnormal(String userName) {
        List<MesAbnormalTime> abnormalTimes = abnormalTimeDao.queryAbnormalTimes(userName);
        //去除异常中的休息时间
        for (MesAbnormalTime abnormal : abnormalTimes) {
            List<MesBatchRest> rests = batchRestDao.queryBatchRest(abnormal.getBatchid());

        }
        return null;
    }
}
