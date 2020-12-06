package jianxin.psyExperiment.service;

import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

public interface WXService {
    ServerReturnObject getOpenId(String code,String appId,String secret);
}
