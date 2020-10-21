package jianxin.psyExperiment.controller;



import jianxin.psyExperiment.entity.ExperimentUserLike;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;

public interface ExperimentUserLikeController {
    //收藏实验
    public ServerReturnObject collectExp(ExperimentUserLike experimentUserLike);

    //取消收藏
    public ServerReturnObject cancelCollectExp(ExperimentUserLike experimentUserLike);
}
