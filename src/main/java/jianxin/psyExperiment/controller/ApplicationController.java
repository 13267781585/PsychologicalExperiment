package jianxin.psyExperiment.controller;
import jianxin.psyExperiment.entity.Application;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
public interface ApplicationController {
    //被试报名实验
    public ServerReturnObject Sign(Application application)throws IllegalAccessException;

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

    //主试通过审核
    public ServerReturnObject testerPass(Integer id,String checkStatus);

    //    被试筛选分页获取报名实验
    public ServerReturnObject userGetExpByExample(@RequestBody Map<String,String>param) throws Exception;

    //    主试筛选分页获取报名被试
    public ServerReturnObject testerGetUserByExample(@RequestBody Map<String,String>param) throws Exception;

    //根据主键删除实验报名
    ServerReturnObject deleteApplicationById(Integer id);

    //将报名表主试和被试完成进度为 已完成的数据 导出为excel
    void printApplicationAllFinished();

}
