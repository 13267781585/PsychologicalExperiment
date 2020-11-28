package jianxin.psyExperiment.service;

import jianxin.psyExperiment.entity.Application;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

import java.util.Map;

public interface ApplicationService {
    ServerReturnObject sign(Application application) throws IllegalAccessException;

    ServerReturnObject findAllRecords();

    ServerReturnObject ifSigned(Application application);

    ServerReturnObject findAllUser(Integer expId);

    ServerReturnObject getExperiment(Integer userId);

    ServerReturnObject userCheck(Integer id,String userSchedule);

    ServerReturnObject testerCheck(Integer id,String testerSchedule);

    ServerReturnObject testerPass(Integer id, String checkStatus);

    ServerReturnObject userGetExpByExample(Map<String,String>param);
}
