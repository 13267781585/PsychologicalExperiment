package jianxin.psyExperiment.service;

import jianxin.psyExperiment.entity.Experiment;
import jianxin.psyExperiment.support.returnEntity.ServerReturnEntity;

public interface ExperimentService {
    ServerReturnEntity getAllExp();

    int addExp(Experiment experiment);

    ServerReturnEntity getTesterExp(Integer testerId);

    ServerReturnEntity deleteExp(Integer id);



}
