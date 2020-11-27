package jianxin.psyExperiment.service;

import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

import java.util.List;

public interface UserService {
    public List<User> findAllUser() throws Exception;

    ServerReturnObject getUser(Integer id) throws Exception;

    ServerReturnObject register(User user) throws Exception;

    ServerReturnObject edit(User user)throws Exception;

    ServerReturnObject coinsInc(Integer userId,Integer increase);

    ServerReturnObject coinsDec(Integer userId,Integer decrease);

    ServerReturnObject creditScoreInc(Integer userId, Float increase);

    ServerReturnObject creditScoreDec(Integer userId, Float decrease);

    ServerReturnObject durationInc(Integer userId, Float increase);
}
