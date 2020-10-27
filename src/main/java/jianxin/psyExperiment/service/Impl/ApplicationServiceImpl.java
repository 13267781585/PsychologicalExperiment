package jianxin.psyExperiment.service.Impl;

import jianxin.psyExperiment.entity.Application;
import jianxin.psyExperiment.entity.Experiment;
import jianxin.psyExperiment.entity.ExperimentUserLike;
import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.mapper.ApplicationMapper;
import jianxin.psyExperiment.mapper.ExperimentMapper;
import jianxin.psyExperiment.mapper.UserMapper;
import jianxin.psyExperiment.service.ApplicationService;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private ExperimentMapper experimentMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerReturnObject sign(Application application) {
        if(application.getCheckStatus()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：checkStatus");
        }
        if(application.getExperimentId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：experimentId");
        }
        if(application.getSignTimestamp()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：signTimestamp");
        }
        if(application.getTesterSchedule()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：testerSchedule");
        }
        if(application.getTimePeriod()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：getTimePeriod");
        }
        if(application.getUserId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：userId");
        }
        if(application.getUserSchedule()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：userSchedule");
        }
        Experiment experiment = experimentMapper.selectByPrimaryKey(application.getExperimentId());
        if(experiment==null)
        {
            return ServerReturnObject.createErrorByMessage("报名实验不存在");
        }
        Integer result = applicationMapper.insert(application);
        if(result>0)
        {
            //报名数加一
            Integer enrollment = experiment.getEnrollment()+1;
            experiment.setEnrollment(enrollment);
            Integer flag =experimentMapper.updateByPrimaryKey(experiment);
            if(flag<=0){
                return ServerReturnObject.createErrorByMessage("报名加一失败");
            }
            Map<String,Object> map=new HashMap<>();
            map.put("enrollment",enrollment);
            return ServerReturnObject.createSuccessByMessageAndData("报名成功",map);
        }
        else{
            return ServerReturnObject.createErrorByMessage("报名失败");
        }

    }

    @Override
    public ServerReturnObject findAllRecords() {
        List<Application> applicationList =applicationMapper.selectAll();
        return ServerReturnObject.createSuccessByMessageAndData("获取成功",applicationList);
    }

    @Override
    public ServerReturnObject ifSigned(Application application) {
        if(application.getExperimentId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：experimentId");
        }
        if(application.getUserId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：userId");
        }

        List<Application> result = applicationMapper.selectByRecord(application);
        if(result != null)
        {
            return ServerReturnObject.createSuccessByMessageAndData("被试已报名",result);
        }
        else{
            return ServerReturnObject.createSuccessByMessage("被试未报名");
        }
    }

    @Override
    public ServerReturnObject findAllUser(Integer expId) {
        if(expId==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：experimentId");
        }
        if(applicationMapper.selectByExperimentId(expId)==null)
        {
            return ServerReturnObject.createErrorByMessage("不存在该id实验");
        }
        List<User>userList=userMapper.selectByExperimentId(expId);
        return ServerReturnObject.createSuccessByMessageAndData("被试获取成功",userList);
    }

    @Override
    public ServerReturnObject getExperiment(Integer userId) {
        if(userId==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：userId");
        }
        if(userMapper.selectByExperimentId(userId)==null)
        {
            return ServerReturnObject.createErrorByMessage("该用户不存在");
        }
        List<Experiment>experimentList=experimentMapper.selectByUserId(userId);
        return ServerReturnObject.createSuccessByMessageAndData("实验获取成功",experimentList);
    }
}
