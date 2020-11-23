package jianxin.psyExperiment.controller;

import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

public interface AttendanceController {
    //签到接口
    public ServerReturnObject checkIn(Integer userId, Integer timestamp);
}
