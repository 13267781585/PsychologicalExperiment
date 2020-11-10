package jianxin.psyExperiment.service.Impl;

import jianxin.psyExperiment.entity.Experiment;
import jianxin.psyExperiment.entity.ExperimentUserLike;
import jianxin.psyExperiment.mapper.ExperimentMapper;
import jianxin.psyExperiment.mapper.ExperimentUserLikeMapper;
import jianxin.psyExperiment.service.ExperimentUserLikeService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperimentUserLikeServiceImpl implements ExperimentUserLikeService {

    @Autowired
    private ExperimentUserLikeMapper experimentUserLikeMapper;

    @Autowired
    private ExperimentMapper experimentMapper;

    @Override
    public ServerReturnEntity collectExp(ExperimentUserLike experimentUserLike) {
        if(experimentUserLike.getExperimentId()==null)
        {
            return ServerReturnEntity.createErrorByMessage("参数不足：experimentId");
        }
        if(experimentUserLike.getUserId()==null)
        {
            return ServerReturnEntity.createErrorByMessage("参数不足：userId");
        }
        int result = experimentUserLikeMapper.insert(experimentUserLike);
        if(result == 1)
        {
            Experiment exp = experimentMapper.selectByPrimaryKey(experimentUserLike.getExperimentId());
            if(exp==null)
            {
                return ServerReturnEntity.createErrorByMessage("收藏实验不存在");
            }
            //实验收藏数加一
            exp.setTotalLikes(exp.getTotalLikes()+1);
            experimentMapper.updateByPrimaryKeySelective(exp);
            return ServerReturnEntity.createSuccessByMessageAndData("收藏成功",exp.getTotalLikes());
        }
        else{
            return ServerReturnEntity.createErrorByMessage("收藏失败");
        }
    }

    @Override
    public ServerReturnEntity cancelCollectExp(ExperimentUserLike experimentUserLike) {
        if(experimentUserLike.getExperimentId()==null)
        {
            return ServerReturnEntity.createErrorByMessage("参数不足：experimentId");
        }
        if(experimentUserLike.getUserId()==null)
        {
            return ServerReturnEntity.createErrorByMessage("参数不足：userId");
        }
        Experiment exp = experimentMapper.selectByPrimaryKey(experimentUserLike.getExperimentId());
        if(exp==null)
        {
            return ServerReturnEntity.createErrorByMessage("收藏实验不存在");
        }
        int result = experimentUserLikeMapper.deleteByRecord(experimentUserLike);
        if(result >= 1)
        {
            //实验收藏数减一
            exp.setTotalLikes(exp.getTotalLikes()-1);
            experimentMapper.updateByPrimaryKeySelective(exp);
            return ServerReturnEntity.createSuccessByMessageAndData("取消收藏成功",exp.getTotalLikes());
        }
        else{
            return ServerReturnEntity.createErrorByMessage("取消收藏失败");
        }
    }
}
