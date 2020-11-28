package jianxin.psyExperiment.controller.Impl;

import jianxin.psyExperiment.controller.TesterController;
import jianxin.psyExperiment.entity.Tester;
import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.service.TesterService;

import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TesterControllerImpl implements TesterController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TesterControllerImpl.class);

    @Autowired
    private TesterService testerService;

    @RequestMapping("/findAllTester")
    public List<Tester> findAllTester() throws Exception {
        LOGGER.info("==================println===========1111");
        return testerService.findAllTester();
    }

    @RequestMapping("/getTester")
    public ServerReturnObject getTester(Integer id)throws Exception{
        LOGGER.info("==================println======================");
        return testerService.getTester(id);
    }

    @RequestMapping("/registerTester")
    public ServerReturnObject registerTester(Tester tester) throws Exception {
        return testerService.registerTester(tester);
    }

    @RequestMapping("/editTester")
    public ServerReturnObject editTester(Tester tester)throws Exception {
        return testerService.editTester(tester);
    }

//    @RequestMapping("/coinsIncrease")
//    public ServerReturnObject coinsInc(Integer userId, Integer increase) {
//        return userService.coinsInc(userId,increase);
//    }
//
//    @RequestMapping("/coinsDecrease")
//    public ServerReturnObject coinsDec(Integer userId, Integer decrease) {
//        return userService.coinsDec(userId,decrease);
//    }

    @RequestMapping("/testerCreditScoreIncrease")
    public ServerReturnObject testerCreditScoreInc(Integer testerId, Float increase) {
        return testerService.testerCreditScoreInc(testerId,increase);
    }

    @RequestMapping("/testerCreditScoreDecrease")
    public ServerReturnObject testerCreditScoreDec(Integer testerId, Float decrease) {
        return testerService.testerCreditScoreDec(testerId,decrease);
    }

//    @RequestMapping("/durationIncrease")
//    public ServerReturnObject durationInc(Integer userId, Float increase) {
//        return userService.durationInc(userId,increase);
//    }
//
//    @RequestMapping("/findUserCoins")
//    public ServerReturnObject findUserCoins(String openId) {
//        return userService.findUserCoins(openId);
//    }
}
