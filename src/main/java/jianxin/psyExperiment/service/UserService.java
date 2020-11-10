package jianxin.psyExperiment.service;

import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.support.returnEntity.ServerReturnEntity;

import java.util.List;

public interface UserService {
    public List<User> findAllUser() throws Exception;

    ServerReturnEntity getUser(Integer id) throws Exception;
}
