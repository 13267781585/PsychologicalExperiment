package jianxin.psyExperiment.service;

import jianxin.psyExperiment.entity.ExperimentUserLike;
import jianxin.psyExperiment.support.returnEntity.ServerReturnEntity;

public interface ExperimentUserLikeService {

    public ServerReturnEntity collectExp(ExperimentUserLike experimentUserLike);

    public ServerReturnEntity cancelCollectExp(ExperimentUserLike experimentUserLike);
}
