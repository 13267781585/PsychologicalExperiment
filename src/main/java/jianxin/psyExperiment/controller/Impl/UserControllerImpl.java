package jianxin.psyExperiment.controller.Impl;

import jianxin.psyExperiment.controller.UserController;
import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.service.UserService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
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

//    @RequestMapping("/findAllUser")//和报名表接口路径名冲突了
//    public List<User> findAllUser() throws Exception {
//        LOGGER.info("==================println===========1111");
//        return userService.findAllUser();
//    }

    @RequestMapping("/getUser")
    public ServerReturnObject getUser(Integer id)throws Exception{
        LOGGER.info("==================println======================");
        return userService.getUser(id);
    }

    @RequestMapping("/registerUser")
    public ServerReturnObject registerUser(User user) throws Exception {
        return userService.registerUser(user);
    }

    @RequestMapping("/editUser")
    public ServerReturnObject editUser(User user)throws Exception {
        return userService.editUser(user);
    }

    @RequestMapping("/userCoinsIncrease")
    public ServerReturnObject userCoinsInc(Integer userId, Integer increase) {
        return userService.userCoinsInc(userId,increase);
    }

    @RequestMapping("/userCoinsDecrease")
    public ServerReturnObject userCoinsDec(Integer userId, Integer decrease) {
        return userService.userCoinsDec(userId,decrease);
    }

    @RequestMapping("/userCreditScoreIncrease")
    public ServerReturnObject userCreditScoreInc(Integer userId, Float increase) {
        return userService.userCreditScoreInc(userId,increase);
    }

    @RequestMapping("/userCreditScoreDecrease")
    public ServerReturnObject userCreditScoreDec(Integer userId, Float decrease) {
        return userService.userCreditScoreDec(userId,decrease);
    }

    @RequestMapping("/userDurationIncrease")
    public ServerReturnObject userDurationInc(Integer userId, Float increase) {
        return userService.userDurationInc(userId,increase);
    }

    @RequestMapping("/findUserCoins")
    public ServerReturnObject findUserCoins(String openId) {
        return userService.findUserCoins(openId);
    }
}
