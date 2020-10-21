package jianxin.psyExperiment.controller;

import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;

import java.util.List;

public interface UserController {
    List<User> findAllUser() throws Exception;

    ServerReturnObject getUser(Integer id) throws Exception;
}
