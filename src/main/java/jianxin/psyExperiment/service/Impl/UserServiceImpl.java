package jianxin.psyExperiment.service.Impl;

import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.mapper.UserMapper;
import jianxin.psyExperiment.service.UserService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnEntity;
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
    public ServerReturnEntity getUser(Integer id) throws Exception {
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
        return ServerReturnEntity.createSuccessByMessageAndData("获取成功",result);
    }
}
