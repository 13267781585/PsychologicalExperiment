package jianxin.psyExperiment.service;

import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

import java.util.List;

public interface UserService {
    public List<User> findAllUser() throws Exception;

    ServerReturnObject getUser(Integer id) throws Exception;

    ServerReturnObject registerUser(User user) throws Exception;

    ServerReturnObject editUser(User user)throws Exception;

    ServerReturnObject userCoinsInc(Integer userId, Integer increase);

    ServerReturnObject userCoinsDec(Integer userId, Integer decrease);

    ServerReturnObject userCreditScoreInc(Integer userId, Float increase);

    ServerReturnObject userCreditScoreDec(Integer userId, Float decrease);

    ServerReturnObject userDurationInc(Integer userId, Float increase);

    ServerReturnObject findUserCoins(String openId);
}
