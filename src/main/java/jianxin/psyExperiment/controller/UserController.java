package jianxin.psyExperiment.controller;

import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;

import java.util.List;

public interface UserController {
    //获取所有用户
    List<User> findAllUser() throws Exception;

    //获取指定id用户
    ServerReturnObject getUser(Integer id) throws Exception;

    //用户注册
    ServerReturnObject register(User user)throws Exception;

    //编辑用户信息
    ServerReturnObject edit(User user);
}
