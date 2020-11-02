package jianxin.psyExperiment.service;

import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public List<User> findAllUser() throws Exception;

    ServerReturnObject getUser(Integer id) throws Exception;

    ServerReturnObject register(User user) throws Exception;

    ServerReturnObject edit(User user)throws Exception;

    public ServerReturnObject coinsInc(Integer userId,Integer increase);

    public ServerReturnObject coinsDec(Integer userId,Integer decrease);
}
