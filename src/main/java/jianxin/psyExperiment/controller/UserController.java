package jianxin.psyExperiment.controller;

import jianxin.psyExperiment.entity.User;

import java.util.List;

public interface UserController {
    List<User> findAllUser() throws Exception;
}
