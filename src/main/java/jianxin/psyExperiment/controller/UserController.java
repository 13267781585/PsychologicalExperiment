package jianxin.psyExperiment.controller;

import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.support.returnEntity.ServerReturnEntity;

import java.util.List;

public interface UserController {
    List<User> findAllUser() throws Exception;

    ServerReturnEntity getUser(Integer id) throws Exception;
}
