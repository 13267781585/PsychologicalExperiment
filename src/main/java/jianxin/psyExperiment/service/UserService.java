package jianxin.psyExperiment.service;

import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;

import java.util.List;

public interface UserService {
    public List<User> findAllUser() throws Exception;

    ServerReturnObject getUser(Integer id) throws Exception;
}
