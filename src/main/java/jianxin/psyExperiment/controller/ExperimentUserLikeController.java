package jianxin.psyExperiment.controller;



import jianxin.psyExperiment.entity.ExperimentUserLike;
import jianxin.psyExperiment.support.returnEntity.ServerReturnEntity;

public interface ExperimentUserLikeController {
    //收藏实验
    public ServerReturnEntity collectExp(ExperimentUserLike experimentUserLike);

    //取消收藏
    public ServerReturnEntity cancelCollectExp(ExperimentUserLike experimentUserLike);
}
