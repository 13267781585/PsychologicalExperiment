package jianxin.psyExperiment.service.Impl;

import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.mapper.UserMapper;
import jianxin.psyExperiment.service.UserService;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;
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
}
