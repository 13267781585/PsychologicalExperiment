package jianxin.psyExperiment.service.Impl;

import jianxin.psyExperiment.service.WXService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import jianxin.psyExperiment.support.util.ComUtils;
import jianxin.psyExperiment.support.util.WXUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WXServiceImpl implements WXService {
    @Autowired
    private WXUtil wxUtil;

    @Override
    public ServerReturnObject getOpenId(String code,String appId,String secret) {
        String openId = wxUtil.getOpenId(code,appId,secret);
        return ComUtils.isEmpty(openId) ? ServerReturnObject.createErrorByMessage("获取openId失败") : ServerReturnObject.createSuccessByData(openId);
    }

}
