package jianxin.psyExperiment.controller.Impl;

import jianxin.psyExperiment.controller.WXController;
import jianxin.psyExperiment.service.WXService;
import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import jianxin.psyExperiment.support.util.ComUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/wx")
@RestController
public class WXControllerImpl implements WXController {
    @Autowired
    private WXService wxService;

    @RequestMapping("/getOpenId")
    public ServerReturnObject getOpenId(String code,String appId,String secret) throws Exception {
        if(ComUtils.isEmpty(code))
            throw new Exception("系统错误");
        return wxService.getOpenId(code,appId,secret);
    }

}

