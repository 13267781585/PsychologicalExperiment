package jianxin.psyExperiment.service;

import jianxin.psyExperiment.entity.Duration;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

public interface DurationService {
    ServerReturnObject insertDuration(Duration duration) throws IllegalAccessException;
}
