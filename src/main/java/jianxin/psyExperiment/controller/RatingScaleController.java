package jianxin.psyExperiment.controller;

import jianxin.psyExperiment.entity.RatingScale;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

public interface RatingScaleController {
    //评分
    public ServerReturnObject mark(RatingScale ratingScale)throws IllegalAccessException;

    //判断是否评分
    public ServerReturnObject ifMarked(RatingScale ratingScale)throws IllegalAccessException;
}
