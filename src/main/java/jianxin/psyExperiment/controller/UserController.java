package jianxin.psyExperiment.controller;

import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

import java.util.List;

public interface UserController {
//    //获取所有用户
//    List<User> findAllUser() throws Exception;

    //获取指定id用户
    ServerReturnObject getUser(Integer id) throws Exception;

    //用户注册
    ServerReturnObject registerUser(User user)throws Exception;

    //编辑用户信息
    ServerReturnObject editUser(User user)throws Exception;

    //用户代币增加
    public ServerReturnObject userCoinsInc(Integer userId,Integer increase);

    //用户代币减少
    public ServerReturnObject userCoinsDec(Integer userId,Integer decrease);

    //用户信誉分增加
    public ServerReturnObject userCreditScoreInc(Integer userId,Float increase);

    //用户信誉分减少
    public ServerReturnObject userCreditScoreDec(Integer userId,Float decrease);

    //用户实验时增加
    public ServerReturnObject userDurationInc(Integer userId,Float increase);

    //获取被试代币数（根据open_id)
    public ServerReturnObject findUserCoins(String openId);
}
