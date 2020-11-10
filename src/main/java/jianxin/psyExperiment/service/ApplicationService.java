package jianxin.psyExperiment.service;

import jianxin.psyExperiment.entity.Application;
import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;

public interface ApplicationService {
    ServerReturnObject sign(Application application);

    ServerReturnObject findAllRecords();

    ServerReturnObject ifSigned(Application application);

    ServerReturnObject findAllUser(Integer expId);

    ServerReturnObject getExperiment(Integer userId);

    ServerReturnObject userCheck(Integer id,String userSchedule);

    ServerReturnObject testerCheck(Integer id,String testerSchedule);
}
