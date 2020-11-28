package jianxin.psyExperiment.controller;


import jianxin.psyExperiment.entity.Experiment;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

import java.util.Map;

public interface ExperimentController {

    //发布实验
    public ServerReturnObject insertExperiment(Experiment experiment) throws Exception;

    //修改实验
    public ServerReturnObject updateExperiment(Experiment experiment)throws IllegalAccessException;

    //获取指定id的实验接口
    public ServerReturnObject selectById(Integer id);

    //获取指定主试的所有实验接口
    public ServerReturnObject getTesterExp(Integer testerId);

    //删除指定id实验
    public ServerReturnObject deleteExp(Integer id) throws Exception;
//    //收藏实验
//    public Map collectExp(Integer experimentId,Integer userId);
    //浏览人数加一
    public ServerReturnObject PageViewPlus(Integer id) throws Exception;

    //按照条件搜索实验
    ServerReturnObject selectExperimentByExample(Map<String,String> example);

    //按照主试id和状态搜索实验
    ServerReturnObject testerGetExpByExample(Map<String, String> param);
}
