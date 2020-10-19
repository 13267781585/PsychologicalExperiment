package jianxin.psyExperiment.controller.Impl;

import jianxin.psyExperiment.controller.UserController;
import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAllUser() throws Exception {
        return userService.findAllUser();
    }
}
