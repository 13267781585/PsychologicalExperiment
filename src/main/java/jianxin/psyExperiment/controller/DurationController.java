package jianxin.psyExperiment.controller;

import jianxin.psyExperiment.entity.Duration;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

import java.util.Map;

public interface DurationController {
    //实验时添加记录插入
    ServerReturnObject insertDuration(Duration duration)throws IllegalAccessException;
}
