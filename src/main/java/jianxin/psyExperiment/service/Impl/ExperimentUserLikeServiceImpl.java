package jianxin.psyExperiment.service.Impl;

import jianxin.psyExperiment.entity.Experiment;
import jianxin.psyExperiment.entity.ExperimentUserLike;
import jianxin.psyExperiment.mapper.ExperimentMapper;
import jianxin.psyExperiment.mapper.ExperimentUserLikeMapper;
import jianxin.psyExperiment.service.ExperimentUserLikeService;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ExperimentUserLikeServiceImpl implements ExperimentUserLikeService {

    @Autowired
    private ExperimentUserLikeMapper experimentUserLikeMapper;

    @Autowired
    private ExperimentMapper experimentMapper;

    @Override
    public ServerReturnObject collectExp(ExperimentUserLike experimentUserLike) {
        if(experimentUserLike.getExperimentId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：experimentId");
        }
        if(experimentUserLike.getUserId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：userId");
        }
        Experiment exp = experimentMapper.selectByPrimaryKey(experimentUserLike.getExperimentId());
        if(exp==null)
        {
            return ServerReturnObject.createErrorByMessage("收藏实验不存在");
        }
        int result = experimentUserLikeMapper.insert(experimentUserLike);
        if(result == 1)
        {

            //实验收藏数加一
            Integer totalLikes = exp.getTotalLikes()+1;
            exp.setTotalLikes(totalLikes);
            Integer flag = experimentMapper.updateByPrimaryKeySelective(exp);
            if(flag<=0)
                return ServerReturnObject.createErrorByMessage("收藏数加一失败");
            Map<String,Object>map=new HashMap<>();
            map.put("totalLikes",totalLikes);
            return ServerReturnObject.createSuccessByMessageAndData("收藏成功",map);
        }
        else{
            return ServerReturnObject.createErrorByMessage("收藏失败");
        }
    }

    @Override
    public ServerReturnObject cancelCollectExp(ExperimentUserLike experimentUserLike) {
        if(experimentUserLike.getExperimentId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：experimentId");
        }
        if(experimentUserLike.getUserId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：userId");
        }
        Experiment exp = experimentMapper.selectByPrimaryKey(experimentUserLike.getExperimentId());
        if(exp==null)
        {
            return ServerReturnObject.createErrorByMessage("收藏实验不存在");
        }
        int result = experimentUserLikeMapper.deleteByRecord(experimentUserLike);
        if(result >= 1)
        {
            //实验收藏数减一
            exp.setTotalLikes(exp.getTotalLikes()-1);
            experimentMapper.updateByPrimaryKeySelective(exp);
            return ServerReturnObject.createSuccessByMessageAndData("取消收藏成功",exp.getTotalLikes());
        }
        else{
            return ServerReturnObject.createErrorByMessage("取消收藏失败");
        }
    }

    @Override
    public ServerReturnObject ifCollected(ExperimentUserLike experimentUserLike) {
        if(experimentUserLike.getExperimentId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：experimentId");
        }
        if(experimentUserLike.getUserId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：userId");
        }

        ExperimentUserLike result = experimentUserLikeMapper.selectByRecord(experimentUserLike);
        if(result != null)
        {
            //实验收藏数减一
            return ServerReturnObject.createSuccessByMessageAndData("已收藏",result);
        }
        else{
            return ServerReturnObject.createSuccessByMessage("未收藏");
        }
    }

    @Override
    public ServerReturnObject findCollections(Integer userId) {
        List<Integer> idList = experimentUserLikeMapper.selectByUserId(userId);

        List<Experiment> experimentList = new ArrayList<Experiment>();
        Experiment temp;
        for(int i = 0;i<idList.size();i++)
        {
            temp = experimentMapper.selectByPrimaryKey(idList.get(i));
            experimentList.add(temp);
        }
        return ServerReturnObject.createSuccessByMessageAndData("数据获取成功",experimentList);

    }
}
