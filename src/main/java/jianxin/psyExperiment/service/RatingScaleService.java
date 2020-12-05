package jianxin.psyExperiment.service;

import jianxin.psyExperiment.entity.RatingScale;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

public interface RatingScaleService {

    ServerReturnObject mark(RatingScale ratingScale) throws IllegalAccessException;

    ServerReturnObject ifMarked(RatingScale ratingScale);
}
