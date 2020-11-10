package jianxin.psyExperiment.controller.Impl;
import jianxin.psyExperiment.controller.CancelTimePeriodController;
import jianxin.psyExperiment.entity.CancelTimePeriod;
import jianxin.psyExperiment.service.CancelTimePeriodService;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CancelTimePeriodControllerImpl implements CancelTimePeriodController{
    @Autowired
    private CancelTimePeriodService cancelTimePeriodService;

    @RequestMapping("/cancelTime")
    public ServerReturnObject cancelTime(CancelTimePeriod record) {
        return cancelTimePeriodService.cancelTime(record);
    }
}
