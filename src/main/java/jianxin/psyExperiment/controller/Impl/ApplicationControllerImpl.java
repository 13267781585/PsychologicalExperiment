package jianxin.psyExperiment.controller.Impl;
import jianxin.psyExperiment.controller.ApplicationController;
import jianxin.psyExperiment.entity.Application;
import jianxin.psyExperiment.service.ApplicationService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import jianxin.psyExperiment.support.util.ComUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class ApplicationControllerImpl implements  ApplicationController{
    @Autowired
    private ApplicationService applicationService;

    @RequestMapping("/sign")
    public ServerReturnObject Sign(Application application)throws IllegalAccessException {
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

    @RequestMapping("/userGetExpByExample")
    public ServerReturnObject userGetExpByExample(Map<String, String> param) throws Exception {
        if(ComUtils.isEmpty(param.get("userId")))
            throw new Exception("用户id不能为空");
        return applicationService.userGetExpByExample(param);
    }
    @RequestMapping("/testerGetUserByExample")
    public ServerReturnObject testerGetUserByExample(Map<String, String> param) throws Exception {
        if(ComUtils.isEmpty(param.get("experimentId")))
            throw new Exception("实验id不能为空");
        return applicationService.testerGetUserByExample(param);
    }

    @RequestMapping("/deleteApplicationById")
    public ServerReturnObject deleteApplicationById(Integer id) {
        return applicationService.deleteApplicationById(id);
    }
}
