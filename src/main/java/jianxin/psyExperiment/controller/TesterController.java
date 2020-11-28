package jianxin.psyExperiment.controller;

import jianxin.psyExperiment.entity.Tester;
import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

import java.util.List;

public interface TesterController {
    //获取所有用户
    List<Tester> findAllTester() throws Exception;

    //获取指定id用户
    ServerReturnObject getTester(Integer id) throws Exception;

    //用户注册
    ServerReturnObject registerTester(Tester tester)throws Exception;

    //编辑用户信息
    ServerReturnObject editTester(Tester tester)throws Exception;

//    //用户代币增加
//    public ServerReturnObject coinsInc(Integer userId,Integer increase);
//
//    //用户代币减少
//    public ServerReturnObject coinsDec(Integer userId,Integer decrease);

    //用户信誉分增加
    public ServerReturnObject testerCreditScoreInc(Integer testerId,Float increase);

    //用户信誉分减少
    public ServerReturnObject testerCreditScoreDec(Integer testerId,Float decrease);

//    //用户实验时增加
//    public ServerReturnObject durationInc(Integer userId,Float increase);
//
//    //获取被试代币数（根据open_id)
//    public ServerReturnObject findUserCoins(String openId);
}
