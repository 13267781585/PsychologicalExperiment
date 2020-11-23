package jianxin.psyExperiment.controller.Impl;
import jianxin.psyExperiment.controller.ApplicationController;
import jianxin.psyExperiment.entity.Application;
import jianxin.psyExperiment.service.ApplicationService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class ApplicationControllerImpl implements  ApplicationController{
    @Autowired
    private ApplicationService applicationService;

    @RequestMapping("/sign")
    public ServerReturnObject Sign(Application application) {
        return applicationService.sign(application);
    }

    @RequestMapping("/findAllRecords")
    public ServerReturnObject findAllRecords() {
        return applicationService.findAllRecords();
    }

    @RequestMapping("/ifSigned")
    public ServerReturnObject ifSigned(Application application) {
        return applicationService.ifSigned(application);
    }

    @RequestMapping("/findAllUser")
    public ServerReturnObject findAllUser(Integer experimentId){
        return applicationService.findAllUser(experimentId);
    }

    @RequestMapping("/getExperiment")
    public ServerReturnObject userGetExp(Integer userId)
    {
        return applicationService.getExperiment(userId);
    }

    @RequestMapping("/userCheck")
    public ServerReturnObject userCheck(Integer id, String userSchedule) {
        return applicationService.userCheck(id,userSchedule);
    }

    @RequestMapping("/testerCheck")
    public ServerReturnObject testerCheck(Integer id, String testerSchedule) {
        return applicationService.testerCheck(id,testerSchedule);
    }

    @RequestMapping("/testerPass")
    public ServerReturnObject testerPass(Integer id, String checkStatus) {
        return applicationService.testerPass(id,checkStatus);
    }
}
