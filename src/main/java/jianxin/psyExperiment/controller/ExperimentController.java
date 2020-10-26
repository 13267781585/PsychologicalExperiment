package jianxin.psyExperiment.controller;


import jianxin.psyExperiment.entity.Experiment;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;

import java.util.List;
import java.util.Map;

public interface ExperimentController {
    public ServerReturnObject findAllExperiment();

    //发布实验
    public ServerReturnObject insertExperiment(Experiment experiment);

    //获取指定id的实验接口
    public ServerReturnObject selectById(Integer id);

    //获取指定主试的所有实验接口
    public ServerReturnObject getTesterExp(Integer testerId);

    //删除指定id实验
    public ServerReturnObject deleteExp(Integer id);

//    //收藏实验
//    public Map collectExp(Integer experimentId,Integer userId);
    //浏览人数加一
    public ServerReturnObject enrollmentPlus(Integer id);
    //报名人数加一

    //收藏人数加一

}
