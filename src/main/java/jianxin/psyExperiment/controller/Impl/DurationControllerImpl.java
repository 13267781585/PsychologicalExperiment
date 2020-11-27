package jianxin.psyExperiment.controller.Impl;

import jianxin.psyExperiment.controller.DurationController;
import jianxin.psyExperiment.entity.Duration;
import jianxin.psyExperiment.service.DurationService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class DurationControllerImpl implements DurationController {
    @Autowired
    private DurationService durationService;

    @RequestMapping("/insertDuration")
    public ServerReturnObject insertDuration(Duration duration) throws IllegalAccessException{
        return durationService.insertDuration(duration);
    }
}
