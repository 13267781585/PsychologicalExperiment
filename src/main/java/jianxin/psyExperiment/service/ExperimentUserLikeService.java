package jianxin.psyExperiment.service;

import jianxin.psyExperiment.entity.ExperimentUserLike;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;

import java.util.List;
import java.util.Map;
public interface ExperimentUserLikeService {

    public ServerReturnObject collectExp(ExperimentUserLike experimentUserLike);

    public ServerReturnObject cancelCollectExp(ExperimentUserLike experimentUserLike);
}
