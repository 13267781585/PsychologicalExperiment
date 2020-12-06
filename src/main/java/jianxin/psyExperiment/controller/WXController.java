package jianxin.psyExperiment.controller;

import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;

public interface WXController {
    ServerReturnObject getOpenId(String code,String appId,String secret) throws Exception;
}
