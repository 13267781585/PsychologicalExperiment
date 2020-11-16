package jianxin.psyExperiment.service;
import jianxin.psyExperiment.entity.CancelTimePeriod;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

public interface CancelTimePeriodService {
    ServerReturnObject cancelTime(CancelTimePeriod record);
}
