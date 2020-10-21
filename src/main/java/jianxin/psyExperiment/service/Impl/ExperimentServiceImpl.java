package jianxin.psyExperiment.service.Impl;

import jianxin.psyExperiment.entity.Experiment;
import jianxin.psyExperiment.mapper.ExperimentMapper;
import jianxin.psyExperiment.mapper.UserMapper;
import jianxin.psyExperiment.service.ExperimentService;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;
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
    public ServerReturnObject getAllExp() {
        List<Experiment> result = experimentMapper.selectAll();

        return ServerReturnObject.createSuccessByMessageAndData("数据获取成功",result);
    }

    @Override
    public int addExp(Experiment experiment) {
        int aFlag = experimentMapper.insert(experiment);
        return aFlag;
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
    public ServerReturnObject deleteExp(Integer id) {
        if(id==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：id");
        }

        int result = experimentMapper.deleteByPrimaryKey(id);
        if(result==1){
            return ServerReturnObject.createSuccessByMessage("实验删除成功");
        }
        else{
            return ServerReturnObject.createErrorByMessage("指定实验不存在");
        }
    }


}
