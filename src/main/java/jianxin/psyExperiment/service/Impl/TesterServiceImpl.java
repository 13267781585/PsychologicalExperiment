package jianxin.psyExperiment.service.Impl;

import jianxin.psyExperiment.entity.Tester;
import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.mapper.TesterMapper;
import jianxin.psyExperiment.mapper.UserMapper;
import jianxin.psyExperiment.service.TesterService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TesterServiceImpl implements TesterService {
    @Autowired
    private TesterMapper testerMapper;

    @Override
    public List<Tester> findAllTester() throws Exception {
        //throw new Exception("11111");
        return testerMapper.selectAll();
    }

    @Override
    public ServerReturnObject getTester(Integer id) throws Exception {
        //throw new Exception("11111");
        if(id==null)
        {
            throw new Exception("参数不足：id");
        }
        Tester result = testerMapper.selectByPrimaryKey(id);
        if(result==null)
        {
            throw new Exception("指定id用户不存在");
        }
        return ServerReturnObject.createSuccessByMessageAndData("获取成功",result);
    }

    @Override
    public ServerReturnObject registerTester(Tester tester) throws Exception{
        if(tester.getOpenId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：openId");
        }
        if(tester.getIdentity()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：identity");
        }
        List<Tester> exist = testerMapper.selectByOpenId(tester.getOpenId());
        if(exist.size()==0) {

            int result = testerMapper.insertSelective(tester);
            if (result > 0) {
                return ServerReturnObject.createSuccessByMessageAndData("数据添加成功", tester.getId());
            } else {
                throw new Exception("添加失败");
            }
        }else
        {
            return ServerReturnObject.createByCodeAndMessageAndData(1,"已注册",exist.get(0).getId());
//            for(int i = 0;i<exist.size();i++)
//            {
//                if(exist.get(i).getIdentity().equals(tester.getIdentity()))//判断身份是否和这次的身份一样
//                    return ServerReturnObject.createByCodeAndMessageAndData(1,"已注册",exist.get(i).getId());
//            }
//            //之前注册过另一种身份
//
//            int result = testerMapper.insertSelective(tester);
//            if (result > 0) {
//                return ServerReturnObject.createSuccessByMessageAndData("数据添加成功", tester.getId());
//            } else {
//                throw new Exception("添加失败");
//            }
        }

    }

    @Override
    public ServerReturnObject editTester(Tester tester) throws Exception{
        if(tester.getId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：id");
        }
        if(tester.getMajor()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：major");
        }
        if(tester.getGrade()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：grade");
        }
        if(tester.getCollege()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：college");
        }
        if(tester.getPhone()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：phone");
        }
        if(tester.getSex()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：Sex");
        }
        int result = testerMapper.updateByPrimaryKeySelective(tester);
        if(result>0)
        {
            Tester tester1 = testerMapper.selectByPrimaryKey(tester.getId());
            return ServerReturnObject.createSuccessByMessageAndData("数据修改成功",tester1);
        }
        else{
            return ServerReturnObject.createErrorByMessage("数据修改失败");
        }

    }



    @Override
    public ServerReturnObject testerCreditScoreInc(Integer testerId, Float increase) {
        if(testerId==null)
            return ServerReturnObject.createErrorByMessage("参数不足：userId");
        if(increase==null)
            return ServerReturnObject.createErrorByMessage("参数不足：increase");
        if(testerMapper.selectByPrimaryKey(testerId)==null)
            return  ServerReturnObject.createErrorByMessage("指定用户不存在");
        Tester tester= testerMapper.selectByPrimaryKey(testerId);
        Float score = tester.getCreditScore()+increase;
        tester.setCreditScore(score);
        Integer flag= testerMapper.updateByPrimaryKey(tester);
        if(score>100)
            score=100f;
        if(flag>0)
        {
            return ServerReturnObject.createSuccessByMessageAndData("信誉分增加成功",score);
        }
        else{
            return ServerReturnObject.createErrorByMessage("信誉分增加失败");
        }
    }

    @Override
    public ServerReturnObject testerCreditScoreDec(Integer testerId, Float decrease) {
        if(testerId==null)
            return ServerReturnObject.createErrorByMessage("参数不足：userId");
        if(decrease==null)
            return ServerReturnObject.createErrorByMessage("参数不足：decrease");
        if(testerMapper.selectByPrimaryKey(testerId)==null)
            return  ServerReturnObject.createErrorByMessage("指定用户不存在");
        Tester tester= testerMapper.selectByPrimaryKey(testerId);
        Float score=tester.getCreditScore()-decrease;
        if(score<0)
            score=0f;
        tester.setCreditScore(score);
        Integer flag= testerMapper.updateByPrimaryKey(tester);
        if(flag>0)
        {
            return ServerReturnObject.createSuccessByMessageAndData("信誉分减少成功",score);
        }
        else{
            return ServerReturnObject.createErrorByMessage("信誉分减少失败");
        }
    }


}
