package jianxin.psyExperiment.service.Impl;


import jianxin.psyExperiment.support.objIsUtil.ObjIsNullUtil;
import jianxin.psyExperiment.entity.RatingScale;
import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.mapper.RatingScaleMapper;
import jianxin.psyExperiment.mapper.UserMapper;
import jianxin.psyExperiment.service.RatingScaleService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingScaleServiceImpl implements RatingScaleService {
    @Autowired
    private RatingScaleMapper ratingScaleMapper;

    @Autowired
    private UserMapper userMapper;

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
                float rate = (user.getPerformanceScore()*num+ratingScale.getScore())/(num+1);
                user.setPerformanceScore(rate);
                userMapper.updateByPrimaryKey(user);
                return ServerReturnObject.createSuccessByMessageAndData("评分成功",rate);
            }
            else if(ratingScale.getType().equals("tester")){
                Integer testerId = ratingScale.getTesterId();
                User tester = userMapper.selectByPrimaryKey(testerId);
                int num = ratingScaleMapper.getNumByTesterId(testerId);
                //因为有一个评分是系统默认评分 所以需要num+1；
                float rate = (tester.getPerformanceScore()*num+ratingScale.getScore())/(num+1);
                tester.setPerformanceScore(rate);
                userMapper.updateByPrimaryKey(tester);
                return ServerReturnObject.createSuccessByMessageAndData("评分成功",rate);
            }
            return  ServerReturnObject.createErrorByMessage("评分失败");
        }
        else{
            return  ServerReturnObject.createErrorByMessage("评分失败");
        }

    }
}
