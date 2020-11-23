package jianxin.psyExperiment.service;

import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

public interface AttendanceService {
    ServerReturnObject checkIn(Integer userId, Integer timestamp);
}
