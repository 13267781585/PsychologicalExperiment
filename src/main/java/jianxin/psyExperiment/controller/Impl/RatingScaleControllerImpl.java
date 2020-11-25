package jianxin.psyExperiment.controller.Impl;

import jianxin.psyExperiment.controller.RatingScaleController;
import jianxin.psyExperiment.entity.RatingScale;
import jianxin.psyExperiment.service.RatingScaleService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingScaleControllerImpl implements RatingScaleController {
    @Autowired
    private RatingScaleService ratingScaleService;

    @RequestMapping("/mark")
    public ServerReturnObject mark(RatingScale ratingScale)throws IllegalAccessException {
        return ratingScaleService.mark(ratingScale);
    }
}
