package jianxin.psyExperiment.controller.Impl;

import jianxin.psyExperiment.controller.ExperimentController;
import jianxin.psyExperiment.entity.Experiment;
import jianxin.psyExperiment.service.ExperimentService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ExperimentControllerImpl implements ExperimentController {
    @Autowired
    private ExperimentService experimentService;

    @RequestMapping("/findAllExperiment")
    public ServerReturnObject findAllExperiment(){
        return experimentService.findAllExperiment();
    }

    @RequestMapping(value="/insertExperiment")
    public ServerReturnObject insertExperiment(Experiment experiment) throws Exception {
       return experimentService.insertExperiment(experiment);
    }

    @RequestMapping("/selectByExpId")
    public ServerReturnObject selectById(Integer id) {
        return experimentService.selectById(id);
    }

    @RequestMapping("/getTesterExp")
    public ServerReturnObject getTesterExp(Integer testerId) {
        return experimentService.getTesterExp(testerId);
    }

    @RequestMapping("/deleteExp")
    public ServerReturnObject deleteExp(Integer id) throws Exception {
        return experimentService.deleteExp(id);
    }

    @RequestMapping("PageViewPlus")
    public ServerReturnObject PageViewPlus(Integer id) throws Exception {
        return experimentService.PageViewPlus(id);
    }

    @RequestMapping("/selectExperimentByExample")
    public ServerReturnObject selectExperimentByExample(@RequestBody Map<String, String> example) {
        return experimentService.selectExperimentByExample(example);
    }

//    @RequestMapping("/collectExp")
//    public Map collectExp(Integer experimentId, Integer userId) {
//        Map<String,Object>map = experimentService.collectExp(experimentId,userId);
//        return map;
//    }
}
