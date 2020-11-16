package jianxin.psyExperiment.controller;
import jianxin.psyExperiment.entity.Application;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

import java.util.List;
import java.util.Map;
public interface ApplicationController {
    //被试报名实验
    public ServerReturnObject Sign(Application application);

    //获取所有报名记录
    public ServerReturnObject findAllRecords();

    //判断用户是否报名
    public ServerReturnObject ifSigned(Application application);

    //主试获取报名被试
    public ServerReturnObject findAllUser(Integer experimentId);

    //被试获取报名实验
    public ServerReturnObject userGetExp(Integer userId);

    //被试确认完成接口
    public ServerReturnObject userCheck(Integer id,String userSchedule);

    //主试确认完成接口
    public ServerReturnObject testerCheck(Integer id,String testerSchedule);
}
