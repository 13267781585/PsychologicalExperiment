package jianxin.psyExperiment.controller;
import jianxin.psyExperiment.entity.CancelTimePeriod;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;


public interface CancelTimePeriodController {
    //取消时间段
    public ServerReturnObject cancelTime(CancelTimePeriod record);
}
