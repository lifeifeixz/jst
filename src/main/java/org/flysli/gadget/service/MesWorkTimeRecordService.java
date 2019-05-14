package org.flysli.gadget.service;

import org.flysli.gadget.bean.MesAbnormalTime;
import org.flysli.gadget.bean.MesBatchRest;
import org.flysli.gadget.bean.MesWorkTimeRecord;
import org.flysli.gadget.bean.ReportWorktime;
import org.flysli.gadget.bean.dto.RestDate;
import org.flysli.gadget.dao.MesAbnormalTimeDao;
import org.flysli.gadget.dao.MesBatchRestDao;
import org.flysli.gadget.dao.MesWorkTimeRecordDao;
import org.flysli.gadget.dao.ReportWorkTimeDao;
import org.flysli.gadget.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MesWorkTimeRecordService {

    @Autowired
    private MesWorkTimeRecordDao workTimeRecordDao;

    @Autowired
    private MesAbnormalTimeDao abnormalTimeDao;

    @Autowired
    private MesBatchRestDao batchRestDao;

    @Autowired
    private MesBatchRestService batchRestService;

    @Autowired
    private ReportWorkTimeDao reportWorkTimeDao;

    public void list() {
        List<MesWorkTimeRecord> mesWorkTimeRecords = workTimeRecordDao.workTimeRecordList();
        System.out.println("工单号:" +
                "\t上工人员:" +
                "\t上工有效时间:" +
                "\t异常时间:" +
                "\t有效休息时间:" +
                "\t休息用时:");
        for (MesWorkTimeRecord workTime : mesWorkTimeRecords) {
            // 获取异常工时
            Long abnormalHour = getAbnormalTime(workTime);
            //获取休息工时
            Long effectiveRestTime = getEffectiveRestHourByWork(workTime);
            //获取休息用时
            Long restTimeByWork = getRestTimeByWork(workTime);
            //有效工时
            Long effectiveWorkTime = workTime.getEndTime().getTime()
                    - workTime.getStartTime().getTime()
                    - abnormalHour - effectiveRestTime;

            ReportWorktime reportWorktime = new ReportWorktime();
            reportWorktime.setCreateTime(DateUtil.structDate("2019-04-20 08:00:00", "00:00:00"));
            reportWorktime.setAbnormal_hour(abnormalHour);
            reportWorktime.setWork_effective_hour(effectiveWorkTime);
            reportWorktime.setRest_effctive_hour(effectiveRestTime);
            reportWorktime.setUserName(workTime.getUserName());
            reportWorktime.setWorkNo(workTime.getWorkNo());
            reportWorktime.setModNo(workTime.getModuleNo());
            reportWorktime.setRest_hour(restTimeByWork);
            reportWorkTimeDao.save(reportWorktime);
            System.out.println("存储成功");
            System.out.println(workTime.getWorkNo() +
                    "\t" + workTime.getUserName() +
                    "\t" + effectiveWorkTime +
                    "\t" + abnormalHour +
                    "\t" + effectiveRestTime +
                    "\t" + restTimeByWork);
        }
    }

    /**
     * 计算一个上工记录对应的异常
     *
     * @param workTime
     * @return
     */
    public Long getAbnormalTime(MesWorkTimeRecord workTime) {
        Long abnoramlHours = 0L;
        List<MesAbnormalTime> abnormalTimes = abnormalTimeDao.queryAbnormalTimes(workTime.getUserName());
        for (MesAbnormalTime abnormal : abnormalTimes) {
            if (workTime.getBatchid() == abnormal.getBatchid()) {
                //异常工时
                long abnormalHourByWork = DateUtil.calcuTimeSectionIntersection(workTime.getStartTime(),
                        workTime.getEndTime(),
                        abnormal.getExpstartTime(),
                        abnormal.getExpendTime());
                //异常工时中的休息工时
                Long restForAbnormal = reduceRestForAbnormal(abnormal);
                abnoramlHours += abnormalHourByWork - restForAbnormal;
            }

        }
        return abnoramlHours;
    }

    /**
     * 去除异常中的休息时间
     *
     * @param abnormal
     * @return
     */
    public Long reduceRestForAbnormal(MesAbnormalTime abnormal) {
        List<MesBatchRest> mesBatchRests = batchRestDao.queryBatchRest(abnormal.getBatchid());
        Long restHourForAbnormal = 0L;
        for (MesBatchRest rest : mesBatchRests) {
            if (rest.getBatchId() == abnormal.getBatchid()) {
                Date restStartDate = DateUtil.structDate(abnormal.getExpstartTime(), rest.getRestStartTime());
                Date restEndDate = DateUtil.structDate(abnormal.getExpstartTime(), rest.getRestEndTime());
                long restTime = DateUtil.countDateIntersection(abnormal.getExpstartTime(),
                        abnormal.getExpendTime(),
                        restStartDate,
                        restEndDate);
                restHourForAbnormal += restTime;
            }
        }
        return restHourForAbnormal;
    }

    /**
     * 计算工时中的有效休息时间
     *
     * @param workTime
     * @return
     */
    public Long getEffectiveRestHourByWork(MesWorkTimeRecord workTime) {
        Long restHour = 0L;
        List<MesBatchRest> mesBatchRests = batchRestDao.queryBatchRest(workTime.getBatchid());
        for (MesBatchRest rest : mesBatchRests) {
            Date restStartDate = DateUtil.structDate(workTime.getStartTime(), rest.getRestStartTime());
            Date restEndDate = DateUtil.structDate(workTime.getStartTime(), rest.getRestEndTime());
            long effectiveRestTime = DateUtil.calcuTimeSectionIntersection(workTime.getStartTime(),
                    workTime.getEndTime(),
                    restStartDate,
                    restEndDate);
            restHour += effectiveRestTime;
        }

        return restHour;
    }

    /**
     * 获取上工时间范围中使用的休息时间
     *
     * @param work
     * @return
     */
    public Long getRestTimeByWork(MesWorkTimeRecord work) {
        Long restHour = 0L;
        List<RestDate> restDates = batchRestService.structRestDate(work.getStartTime(), work.getBatchid());
        for (RestDate rest : restDates) {
            if (rest.getStart().getTime() > work.getStartTime().getTime()
                    && rest.getStart().getTime() < work.getEndTime().getTime()) {
                restHour += rest.getEnd().getTime() - rest.getStart().getTime();
            }
        }
        return restHour;
    }


}
