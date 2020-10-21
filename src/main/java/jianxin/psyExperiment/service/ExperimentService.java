package jianxin.psyExperiment.service;

import jianxin.psyExperiment.entity.Experiment;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;

import java.util.List;
import java.util.Map;

public interface ExperimentService {
    ServerReturnObject getAllExp();

    int addExp(Experiment experiment);

    ServerReturnObject getTesterExp(Integer testerId);

    ServerReturnObject deleteExp(Integer id);



}
