package com.example.jst.service;

import com.example.jst.bean.MesAbnormalTime;
import com.example.jst.bean.MesBatchRest;
import com.example.jst.dao.MesAbnormalTimeDao;
import com.example.jst.dao.MesBatchRestDao;
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
