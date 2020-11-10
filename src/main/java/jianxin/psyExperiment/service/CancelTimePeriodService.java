package jianxin.psyExperiment.service;
import jianxin.psyExperiment.entity.CancelTimePeriod;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;

public interface CancelTimePeriodService {
    ServerReturnObject cancelTime(CancelTimePeriod record);
}
