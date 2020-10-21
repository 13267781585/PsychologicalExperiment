package jianxin.psyExperiment.controller.Impl;

import jianxin.psyExperiment.controller.ExperimentUserLikeController;
import jianxin.psyExperiment.entity.ExperimentUserLike;
import jianxin.psyExperiment.service.ExperimentService;
import jianxin.psyExperiment.service.ExperimentUserLikeService;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperimentUserLikeControllerImpl implements ExperimentUserLikeController {
    @Autowired
    private ExperimentUserLikeService experimentUserLikeService;

    @RequestMapping("/collectExp")
    public ServerReturnObject collectExp(ExperimentUserLike experimentUserLike) {
        return experimentUserLikeService.collectExp(experimentUserLike);
    }

    @RequestMapping("/cancelCollectExp")
    public ServerReturnObject cancelCollectExp(ExperimentUserLike experimentUserLike) {
        return experimentUserLikeService.cancelCollectExp(experimentUserLike);
    }
}
