package jianxin.psyExperiment.service;

import jianxin.psyExperiment.support.returnEntity.WebSocketReturnEntity;

public interface ConsultMessageService {
     WebSocketReturnEntity selectAllConsultMessageByUserId(Integer userId) throws Exception;
}
