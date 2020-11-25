package jianxin.psyExperiment.service.Impl;

import com.github.pagehelper.PageHelper;
import jianxin.psyExperiment.entity.Experiment;
import jianxin.psyExperiment.mapper.ExperimentMapper;
import jianxin.psyExperiment.service.ExperimentService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExperimentServiceImpl implements ExperimentService {
    @Autowired
    private ExperimentMapper experimentMapper;


    @Override
    public ServerReturnObject findAllExperiment() {
        List<Experiment> result = experimentMapper.selectAll();
        return ServerReturnObject.createSuccessByMessageAndData("数据获取成功",result);
    }

    @Override
    public ServerReturnObject insertExperiment(Experiment experiment) throws Exception{

        if(experiment.getTesterId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：testerId");
        }
        if(experiment.getType()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：type");
        }
        if(experiment.getName()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：name");
        }
        if(experiment.getContent()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：content");
        }
        if(experiment.getDuration()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：duration");
        }
        if(experiment.getReward()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：reward");
        }
        if(experiment.getPlace()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：place");
        }
        if(experiment.getRequirement()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：requirement");
        }
        if(experiment.getTime()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：time");
        }
        if(experiment.getSendTimestamp()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：sendTimestamp");
        }
        if(experiment.getPageView()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：pageView");
        }
        if(experiment.getEnrollment()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：enrollment");
        }
        if(experiment.getTotalLikes()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：totalLikes");
        }
        if(experiment.getTag()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：tag");
        }
        if(experiment.getStatus()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：status");
        }
        if(experiment.getFaceUrl()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：faceUrl");
        }
        if(experiment.getUsername()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：username");
        }
        if(experiment.getTimePeriods()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：timePeriods");
        }

        experiment.setPageView(0);
        experiment.setEnrollment(0);
        experiment.setTotalLikes(0);
        int result = experimentMapper.insert(experiment);
        if(result == 1){
            return ServerReturnObject.createSuccessByMessage("数据添加成功");
        }else{
            return ServerReturnObject.createErrorByMessage("新增实验失败");
        }
    }

    @Override
    public ServerReturnObject getTesterExp(Integer testerId) {

        if(testerId==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：testerId");
        }
        List<Experiment> result = experimentMapper.selectByTesterId(testerId);
        return ServerReturnObject.createSuccessByMessageAndData("数据获取成功",result);

    }

    @Override
    public ServerReturnObject deleteExp(Integer id) throws Exception{
        if(id==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：id");
        }

        int result = experimentMapper.deleteByPrimaryKey(id);
        if(result==1){
            return ServerReturnObject.createSuccessByMessage("实验删除成功");
        }
        else{
            return ServerReturnObject.createErrorByMessage("实验删除失败");
        }
    }

    @Override
    public ServerReturnObject selectById(Integer id) {
        if(id==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：id");
        }
        Experiment result = experimentMapper.selectByPrimaryKey(id);
        if(result!=null){
            return ServerReturnObject.createSuccessByMessageAndData("数据获取成功",result);
        }
        else{
            return ServerReturnObject.createErrorByMessage("指定实验不存在");
        }
    }

    @Override
    public ServerReturnObject PageViewPlus(Integer id) throws Exception{
        Experiment experiment = experimentMapper.selectByPrimaryKey(id);
        if(experiment == null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：id");
        }
        Integer pageView = experiment.getPageView()+1;
        experiment.setPageView(pageView);
        Integer flag = experimentMapper.updateByPrimaryKey(experiment);
        if(flag<=0){
            return ServerReturnObject.createErrorByMessage("浏览数加一失败");
        }
        Map<String,Object> map=new HashMap<>();
        map.put("pageView",pageView);
        return ServerReturnObject.createSuccessByMessageAndData("浏览数加一",map);
    }

    @Override
    public ServerReturnObject selectExperimentByExample(Map<String, String> example) {
        int pageNum = example.get("pageNum") == null ? 1 : Integer.parseInt(example.get("pageNum"));
        int pageSize = example.get("pageSize") == null ? 10 : Integer.parseInt(example.get("pageSize"));
        PageHelper.startPage(pageNum,pageSize);
        return ServerReturnObject.createSuccessByData(experimentMapper.selectByExample(example));
    }


}
