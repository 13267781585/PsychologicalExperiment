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
    ServerReturnObject edit(User user)throws Exception;

    //用户代币增加
    public ServerReturnObject coinsInc(Integer userId,Integer increase);

    //用户代币减少
    public ServerReturnObject coinsDec(Integer userId,Integer decrease);

    //用户信誉分增加
    public ServerReturnObject creditScoreInc(Integer userId,Float increase);

    //用户信誉分减少
    public ServerReturnObject creditScoreDec(Integer userId,Float decrease);


}
