package jianxin.psyExperiment.service.Impl;

import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.mapper.UserMapper;
import jianxin.psyExperiment.service.UserService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() throws Exception {
        //throw new Exception("11111");
        return userMapper.selectAll();
    }

    @Override
    public ServerReturnObject getUser(Integer id) throws Exception {
        //throw new Exception("11111");
        if(id==null)
        {
            throw new Exception("参数不足：id");
        }
        Object result = userMapper.selectByPrimaryKey(id);
        if(result==null)
        {
            throw new Exception("获取失败：指定id用户不存在");
        }
        return ServerReturnObject.createSuccessByMessageAndData("获取成功",result);
    }

    @Override
    public ServerReturnObject register(User user) throws Exception{
        if(user.getOpenId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：openId");
        }
        int result = userMapper.insert(user);
        if(result>0){
            return ServerReturnObject.createSuccessByMessageAndData("数据添加成功",result);
        }else{
            throw new Exception("添加失败");
        }

    }

    @Override
    public ServerReturnObject edit(User user) throws Exception{
        if(user.getId()==null)
        {
            return ServerReturnObject.createErrorByMessage("参数不足：openId");
        }
        int result = userMapper.updateByPrimaryKey(user);
        if(result>0)
        {
            return ServerReturnObject.createSuccessByMessageAndData("数据修改成功",result);
        }
        else{
            return ServerReturnObject.createErrorByMessage("数据修改失败");
        }

    }

    @Override
    public ServerReturnObject coinsInc(Integer userId, Integer increase) {
        if(userId==null)
            return ServerReturnObject.createErrorByMessage("参数不足：userId");
        if(increase==null)
            return ServerReturnObject.createErrorByMessage("参数不足：increase");
        if(userMapper.selectByPrimaryKey(userId)==null)
            return  ServerReturnObject.createErrorByMessage("指定用户不存在");
        User user=userMapper.selectByPrimaryKey(userId);
        Integer coins = user.getCoins()+increase;
        user.setCoins(coins);
        Integer flag=userMapper.updateByPrimaryKey(user);
        if(flag>0)
        {
                return ServerReturnObject.createSuccessByMessageAndData("代币增加成功",coins);
        }
        else{
            return ServerReturnObject.createErrorByMessage("代币增加失败");
        }

    }

    @Override
    public ServerReturnObject coinsDec(Integer userId, Integer decrease) {
        if(userId==null)
            return ServerReturnObject.createErrorByMessage("参数不足：userId");
        if(decrease==null)
            return ServerReturnObject.createErrorByMessage("参数不足：decrease");
        if(userMapper.selectByPrimaryKey(userId)==null)
            return  ServerReturnObject.createErrorByMessage("指定用户不存在");
        User user=userMapper.selectByPrimaryKey(userId);
        Integer coins = user.getCoins()-decrease;
        if(coins<0)
            coins=0;
        user.setCoins(coins);
        Integer flag=userMapper.updateByPrimaryKey(user);
        if(flag>0)
        {
            return ServerReturnObject.createSuccessByMessageAndData("代币减少成功",coins);
        }
        else{
            return ServerReturnObject.createErrorByMessage("代币减少失败");
        }

    }

    @Override
    public ServerReturnObject creditScoreInc(Integer userId, Float increase) {
        if(userId==null)
            return ServerReturnObject.createErrorByMessage("参数不足：userId");
        if(increase==null)
            return ServerReturnObject.createErrorByMessage("参数不足：increase");
        if(userMapper.selectByPrimaryKey(userId)==null)
            return  ServerReturnObject.createErrorByMessage("指定用户不存在");
        User user=userMapper.selectByPrimaryKey(userId);
        Float score = user.getCreditScore()+increase;
        user.setCreditScore(score);
        Integer flag=userMapper.updateByPrimaryKey(user);
        if(flag>0)
        {
            return ServerReturnObject.createSuccessByMessageAndData("信誉分增加成功",score);
        }
        else{
            return ServerReturnObject.createErrorByMessage("信誉分增加失败");
        }
    }

    @Override
    public ServerReturnObject creditScoreDec(Integer userId, Float decrease) {
        if(userId==null)
            return ServerReturnObject.createErrorByMessage("参数不足：userId");
        if(decrease==null)
            return ServerReturnObject.createErrorByMessage("参数不足：decrease");
        if(userMapper.selectByPrimaryKey(userId)==null)
            return  ServerReturnObject.createErrorByMessage("指定用户不存在");
        User user=userMapper.selectByPrimaryKey(userId);
        Float score=user.getCreditScore()-decrease;
        if(score<0)
            score=0f;
        user.setCreditScore(score);
        Integer flag=userMapper.updateByPrimaryKey(user);
        if(flag>0)
        {
            return ServerReturnObject.createSuccessByMessageAndData("信誉分减少成功",score);
        }
        else{
            return ServerReturnObject.createErrorByMessage("信誉分减少失败");
        }
    }
}
