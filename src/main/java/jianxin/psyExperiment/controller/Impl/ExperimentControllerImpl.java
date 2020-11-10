package jianxin.psyExperiment.controller.Impl;

import jianxin.psyExperiment.controller.ExperimentController;
import jianxin.psyExperiment.entity.Experiment;
import jianxin.psyExperiment.service.ExperimentService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ExperimentControllerImpl implements ExperimentController {
    @Autowired
    private ExperimentService experimentService;

<<<<<<< HEAD
    @RequestMapping("/getAllExp")
    public ServerReturnObject getAllExp(){
        return experimentService.getAllExp();
    }

    @RequestMapping(value="/addExp")
    public Map addExp(Experiment experiment){
        Map<String,Object> map = new HashMap<String,Object>();
        int flag = experimentService.addExp(experiment);
        if(flag == 1){
            map.put("msg","新增实验成功了11115546546545");
            return map;
        }else{
            map.put("msg","新增实验失败");
            return map;
        }
=======
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
>>>>>>> ea4a05a7c8c1d3ef24cc668f76ef00c57d7c8fd3
    }

    @RequestMapping("/getTesterExp")
    public ServerReturnObject getTesterExp(Integer testerId) {
        return experimentService.getTesterExp(testerId);
    }

    @RequestMapping("/deleteExp")
<<<<<<< HEAD
    public ServerReturnObject deleteExp(Integer id){
=======
    public ServerReturnObject deleteExp(Integer id) throws Exception {
>>>>>>> ea4a05a7c8c1d3ef24cc668f76ef00c57d7c8fd3

        return experimentService.deleteExp(id);
    }

    @RequestMapping("PageViewPlus")
    public ServerReturnObject PageViewPlus(Integer id) throws Exception {
        return experimentService.PageViewPlus(id);
    }

//    @RequestMapping("/collectExp")
//    public Map collectExp(Integer experimentId, Integer userId) {
//        Map<String,Object>map = experimentService.collectExp(experimentId,userId);
//        return map;
//    }
}
