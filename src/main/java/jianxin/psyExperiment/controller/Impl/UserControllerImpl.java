package jianxin.psyExperiment.controller.Impl;

import jianxin.psyExperiment.controller.UserController;
import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.service.UserService;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerImpl.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAllUser() throws Exception {
        LOGGER.info("==================println===========1111");
        return userService.findAllUser();
    }

    @RequestMapping("/getUser")
    public ServerReturnObject getUser(Integer id)throws Exception{
        LOGGER.info("==================println======================");
        return userService.getUser(id);
    }
}
