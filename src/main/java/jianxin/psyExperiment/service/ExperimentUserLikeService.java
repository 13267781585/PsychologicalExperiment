package jianxin.psyExperiment.service;

import jianxin.psyExperiment.entity.ExperimentUserLike;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

public interface ExperimentUserLikeService {

    public ServerReturnObject collectExp(ExperimentUserLike experimentUserLike);


    public ServerReturnObject cancelCollectExp(ExperimentUserLike experimentUserLike);

    public ServerReturnObject ifCollected(ExperimentUserLike experimentUserLike);

    public ServerReturnObject findCollections(Integer userId);

}
