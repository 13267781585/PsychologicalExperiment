package jianxin.psyExperiment.service.Impl;


import jianxin.psyExperiment.entity.Tester;
import jianxin.psyExperiment.mapper.TesterMapper;
import jianxin.psyExperiment.support.util.ObjIsNullUtil;
import jianxin.psyExperiment.entity.RatingScale;
import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.mapper.RatingScaleMapper;
import jianxin.psyExperiment.mapper.UserMapper;
import jianxin.psyExperiment.service.RatingScaleService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingScaleServiceImpl implements RatingScaleService {
    @Autowired
    private RatingScaleMapper ratingScaleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TesterMapper testerMapper;

    @Override
    public ServerReturnObject mark(RatingScale ratingScale) throws IllegalAccessException {
//        if(ratingScale.getScore()==null)
//        {
//            return ServerReturnObject.createErrorByMessage("参数不足：score");
//        }
//        if(ratingScale.getExperimentId()==null)
//        {
//            return ServerReturnObject.createErrorByMessage("参数不足：experimentId");
//        }
//        if(ratingScale.getTesterId()==null)
//        {
//            return ServerReturnObject.createErrorByMessage("参数不足：testerId");
//        }
//        if(ratingScale.getTimestamp()==null)
//        {
//            return ServerReturnObject.createErrorByMessage("参数不足：timestamp");
//        }
//        if(ratingScale.getType()==null)
//        {
//            return ServerReturnObject.createErrorByMessage("参数不足：type");
//        }
//        if(ratingScale.getUserId()==null)
//        {
//            return ServerReturnObject.createErrorByMessage("参数不足：userId");
//        }
        String name = ObjIsNullUtil.firstNullName(ratingScale);
        if(name!=null){
            return ServerReturnObject.createErrorByMessage("参数不足："+name);
        }
        int result = ratingScaleMapper.insert(ratingScale);
        if(result>0){
            if(ratingScale.getType().equals("user")) {
                Integer userId = ratingScale.getUserId();
                User user = userMapper.selectByPrimaryKey(userId);
                int num = ratingScaleMapper.getNumByUserId(userId);
                //因为有一个评分是系统默认评分 所以需要num+1；
                float rate = 0;
                if(num==1){
                    rate = ratingScale.getScore();
                }
                else{
                    rate = (user.getPerformanceScore()*num+ratingScale.getScore())/(num);
                }
                user.setPerformanceScore(rate);
                userMapper.updateByPrimaryKey(user);
                return ServerReturnObject.createSuccessByMessageAndData("评分成功",rate);
            }
            else if(ratingScale.getType().equals("tester")){
                Integer testerId = ratingScale.getTesterId();
                Tester tester = testerMapper.selectByPrimaryKey(testerId);
                int num = ratingScaleMapper.getNumByTesterId(testerId);
                //因为有一个评分是系统默认评分 所以需要num+1；
                float rate = 0;
                if(num==1){
                    rate = ratingScale.getScore();
                }
                else{
                    rate = (tester.getPerformanceScore()*num+ratingScale.getScore())/(num);
                }

                tester.setPerformanceScore(rate);
                testerMapper.updateByPrimaryKey(tester);
                return ServerReturnObject.createSuccessByMessageAndData("评分成功",rate);
            }
            return  ServerReturnObject.createErrorByMessage("评分失败");
        }
        else{
            return  ServerReturnObject.createErrorByMessage("评分失败");
        }

    }

    @Override
    public ServerReturnObject ifMarked(RatingScale ratingScale) {
        if(ratingScale.getExperimentId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：experimentId");
        }
        if(ratingScale.getTesterId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：testerId");
        }
        if(ratingScale.getType()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：type");
        }
        if(ratingScale.getUserId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：userId");
        }
        List<RatingScale> ratingScaleList= ratingScaleMapper.selectByRecord(ratingScale);
        if(ratingScaleList.size()==0)
        {
            return ServerReturnObject.createByCodeAndMessageAndData(0,"未评分",null);
        }
        else{
            return  ServerReturnObject.createByCodeAndMessageAndData(1,"已评分",ratingScaleList);
        }
    }
}
