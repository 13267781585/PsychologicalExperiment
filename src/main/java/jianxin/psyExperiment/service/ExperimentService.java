package jianxin.psyExperiment.service;

import jianxin.psyExperiment.entity.Experiment;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;

import java.util.List;
import java.util.Map;

public interface ExperimentService {
    ServerReturnObject findAllExperiment();

    ServerReturnObject insertExperiment(Experiment experiment) throws Exception;

    ServerReturnObject getTesterExp(Integer testerId);

    ServerReturnObject deleteExp(Integer id) throws Exception;

    ServerReturnObject selectById(Integer id);

    ServerReturnObject PageViewPlus(Integer id) throws Exception;
}
