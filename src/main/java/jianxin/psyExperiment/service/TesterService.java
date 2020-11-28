package jianxin.psyExperiment.service;

import jianxin.psyExperiment.entity.Tester;
import jianxin.psyExperiment.entity.User;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

import java.util.List;

public interface TesterService {
    public List<Tester> findAllTester() throws Exception;

    ServerReturnObject getTester(Integer id) throws Exception;

    ServerReturnObject registerTester(Tester tester) throws Exception;

    ServerReturnObject editTester(Tester tester)throws Exception;



    ServerReturnObject testerCreditScoreInc(Integer testerId, Float increase);

    ServerReturnObject testerCreditScoreDec(Integer testerId, Float decrease);


}
