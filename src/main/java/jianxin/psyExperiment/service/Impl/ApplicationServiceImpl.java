package jianxin.psyExperiment.service.Impl;

import jianxin.psyExperiment.entity.Application;
import jianxin.psyExperiment.entity.Experiment;
import jianxin.psyExperiment.entity.ExperimentUserLike;
import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.mapper.ApplicationMapper;
import jianxin.psyExperiment.mapper.ExperimentMapper;
import jianxin.psyExperiment.mapper.UserMapper;
import jianxin.psyExperiment.service.ApplicationService;
import jianxin.psyExperiment.support.objIsUtil.ObjIsNullUtil;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
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
    public ServerReturnObject sign(Application application) throws IllegalAccessException {
//        if(application.getCheckStatus()==null)
//        {
//            return ServerReturnObject.createErrorByMessage("参数不足：checkStatus");
//        }
        if(application.getExperimentId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：experimentId");
        }
        if(application.getSignTimestamp()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：signTimestamp");
        }
//        if(application.getTesterSchedule()==null)
//        {
//            return ServerReturnObject.createErrorByMessage("参数不足：testerSchedule");
//        }
        if(application.getTimePeriod()==null)
        {git
            return ServerReturnObject.createErrorByMessage("参数不足：timePeriod");
        }
        if(application.getUserId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：userId");
        }
//        if(application.getUserSchedule()==null)
//        {
//            return ServerReturnObject.createErrorByMessage("参数不足：userSchedule");
//        }
//        String name = ObjIsNullUtil.isAllFieldNotNull(application);
//        if(name!=null){
//            return ServerReturnObject.createErrorByMessage("参数不足："+name);
//        }
        Experiment experiment = experimentMapper.selectByPrimaryKey(application.getExperimentId());
        if(experiment==null)
        {
            return ServerReturnObject.createErrorByMessage("报名实验不存在");
        }
        Integer result = applicationMapper.insertSelective(application);
        if(result>0)
        {
            //报名数加一
            Integer enrollment = experiment.getEnrollment()+1;
            experiment.setEnrollment(enrollment);
            Integer flag =experimentMapper.updateByPrimaryKey(experiment);
            if(flag<=0){
                return ServerReturnObject.createErrorByMessage("报名加一失败");
            }

            return ServerReturnObject.createSuccessByMessageAndData("报名成功",enrollment);
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

    @Override
    public ServerReturnObject userCheck(Integer id, String userSchedule) {
        if(id==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：id");
        }
        if(userSchedule==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：userSchedule");
        }
        Application record=applicationMapper.selectByPrimaryKey(id);
        if(record==null)
        {
            return ServerReturnObject.createErrorByMessage("报名不存在");
        }
        if(userSchedule.equals("已完成"))
        {
            record.setUserSchedule("已完成");
            applicationMapper.updateByPrimaryKey(record);
            return ServerReturnObject.createSuccessByMessageAndData("被试确认完成", record);
        }
        else if(userSchedule.equals("未完成"))
        {
            record.setUserSchedule("未完成");
            applicationMapper.updateByPrimaryKey(record);
            return ServerReturnObject.createSuccessByMessageAndData("被试确认未完成", record);
        }
        return ServerReturnObject.createErrorByMessage("被试确认失败");
    }

    @Override
    public ServerReturnObject testerCheck(Integer id, String testerSchedule) {
        if(id==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：id");
        }
        if(testerSchedule==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：testerSchedule");
        }

        Application record=applicationMapper.selectByPrimaryKey(id);
        if(record==null)
        {
            return ServerReturnObject.createErrorByMessage("报名不存在");
        }
        if(testerSchedule.equals("已完成"))
        {
            record.setTesterSchedule("已完成");
            applicationMapper.updateByPrimaryKey(record);
            return ServerReturnObject.createSuccessByMessageAndData("主试确认完成", record);
        }
        else if(testerSchedule.equals("未完成"))
        {
            record.setTesterSchedule("未完成");
            applicationMapper.updateByPrimaryKey(record);
            return ServerReturnObject.createSuccessByMessageAndData("主试确认未完成", record);
        }
        return ServerReturnObject.createErrorByMessage("主试确认失败");
    }

    @Override
    public ServerReturnObject testerPass(Integer id, String checkStatus) {
        if(id==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：id");
        }
        if(checkStatus==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：testerSchedule");
        }

        Application record=applicationMapper.selectByPrimaryKey(id);
        if(record==null)
        {
            return ServerReturnObject.createErrorByMessage("报名不存在");
        }
        if(checkStatus.equals("已通过"))
        {
            record.setCheckStatus("已通过");
            applicationMapper.updateByPrimaryKey(record);
            return ServerReturnObject.createSuccessByMessageAndData("主试通过报名", record);
        }
        else if(checkStatus.equals("未通过"))
        {
            record.setCheckStatus("未通过");
            applicationMapper.updateByPrimaryKey(record);
            return ServerReturnObject.createSuccessByMessageAndData("主试不通过报名", record);
        }
        return ServerReturnObject.createErrorByMessage("主试通过失败");
    }
}
