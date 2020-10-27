package jianxin.psyExperiment.controller;
import jianxin.psyExperiment.entity.Application;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;

import java.util.List;
import java.util.Map;
public interface ApplicationController {
    //被试报名实验
    public ServerReturnObject Sign(Application application);

    //获取所有报名记录
    public ServerReturnObject findAllRecords();

    //判断用户是否报名
    public ServerReturnObject ifSigned(Application application);
}
