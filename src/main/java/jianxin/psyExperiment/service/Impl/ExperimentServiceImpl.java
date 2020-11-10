package jianxin.psyExperiment.service.Impl;

import jianxin.psyExperiment.entity.Experiment;
import jianxin.psyExperiment.mapper.ExperimentMapper;
import jianxin.psyExperiment.service.ExperimentService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperimentServiceImpl implements ExperimentService {
    @Autowired
    private ExperimentMapper experimentMapper;


    @Override
    public ServerReturnEntity getAllExp() {
        List<Experiment> result = experimentMapper.selectAll();

        return ServerReturnEntity.createSuccessByMessageAndData("数据获取成功",result);
    }

    @Override
    public int addExp(Experiment experiment) {
        int aFlag = experimentMapper.insert(experiment);
        return aFlag;
    }

    @Override
    public ServerReturnEntity getTesterExp(Integer testerId) {

        if(testerId==null)
        {
            return ServerReturnEntity.createErrorByMessage("参数不足：testerId");
        }
        List<Experiment> result = experimentMapper.selectByTesterId(testerId);
        return ServerReturnEntity.createSuccessByMessageAndData("数据获取成功",result);

    }

    @Override
    public ServerReturnEntity deleteExp(Integer id) {
        if(id==null)
        {
            return ServerReturnEntity.createErrorByMessage("参数不足：id");
        }

        int result = experimentMapper.deleteByPrimaryKey(id);
        if(result==1){
            return ServerReturnEntity.createSuccessByMessage("实验删除成功");
        }
        else{
            return ServerReturnEntity.createErrorByMessage("指定实验不存在");
        }
    }


}
