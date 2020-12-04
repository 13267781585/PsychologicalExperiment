package jianxin.psyExperiment.support.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

// TODO: 2020/12/1  将http get和post操作抽取出来后还没有完整测试过
//与微信小程序官方api 交互的一些操作
@Service
public class WXUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(WXUtil.class);
    //微信小程序 密匙
    @Value("${wx.APP_ID}")
    private String APP_ID;
    @Value("${wx.APP_SECRET}")
    private String APP_SECRET;

    //小程序的access_token
    //有效时间是7200s
    private static String ACCESS_TOKEN;
    private static long ACCESS_TOKEN_OUTTIME;

    //小程序openId
    private static String OPEN_ID;

    /*
   获取小程序全局唯一后台接口调用凭据（access_token）
    */
    public String WXGetAccessToken(){
        //判断 ACCESS_TOKEN 是否为空和是否过期
        if(ACCESS_TOKEN != null && ((System.currentTimeMillis() - ACCESS_TOKEN_OUTTIME) / 1000 < 6000))
            return ACCESS_TOKEN;

        //微信获取 access_token api
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&";
        url += "appid=" + APP_ID + "&secret=" + APP_SECRET;

        Map<String,String> responseContent = HttpUtil.GetHttp(url,false);
        //从响应体中获取access_token
        String access_token = responseContent.get("access_token");

        LOGGER.debug("=== 微信access_token: " + access_token + "===");
        ACCESS_TOKEN = access_token;
        ACCESS_TOKEN_OUTTIME = System.currentTimeMillis();
        return  access_token;
    }

    /*

    获取小程序openId
    code => 调用微信官方接口获取登录凭证（code）
     */
    public String getOpenId(String code){
        //判断 ACCESS_TOKEN 是否为空和是否过期
        if(OPEN_ID != null)
            return OPEN_ID;

        //微信获取 access_token api
        String url = "https://api.weixin.qq.com/sns/jscode2session?grant_type=authorization_code&"+ "appid=" + APP_ID + "&secret=" + APP_SECRET +
                "&js_code=" + code;

        Map<String,String> responseContent = HttpUtil.GetHttp(url,false);
        //从响应体中获取access_token
        String open_id = responseContent.get("openid");

        LOGGER.debug("=== open_id: " + open_id + "===");
        OPEN_ID = open_id;
        return  OPEN_ID;
    }

}
