package jianxin.psyExperiment.controller.Impl;

import jianxin.psyExperiment.controller.ExperimentController;
import jianxin.psyExperiment.entity.Experiment;
import jianxin.psyExperiment.service.ExperimentService;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ExperimentControllerImpl implements ExperimentController {
    @Autowired
    private ExperimentService experimentService;

    @RequestMapping("/getAllExp")
    public ServerReturnObject getAllExp(){
        return experimentService.getAllExp();
    }

    @RequestMapping(value="/addExp")
    public Map addExp(Experiment experiment){
        Map<String,Object> map = new HashMap<String,Object>();
        int flag = experimentService.addExp(experiment);
        if(flag == 1){
            map.put("msg","新增实验成功");
            return map;
        }else{
            map.put("msg","新增实验失败");
            return map;
        }
    }

    @RequestMapping("/getTesterExp")
    public ServerReturnObject getTesterExp(Integer testerId) {
        return experimentService.getTesterExp(testerId);
    }

    @RequestMapping("/deleteExp")
    public ServerReturnObject deleteExp(Integer id){

        return experimentService.deleteExp(id);
    }

//    @RequestMapping("/collectExp")
//    public Map collectExp(Integer experimentId, Integer userId) {
//        Map<String,Object>map = experimentService.collectExp(experimentId,userId);
//        return map;
//    }
}
