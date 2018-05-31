package cn.myzqu.pojo.wechat;

import cn.myzqu.utils.HttpRequestUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信小程序敏感信息类
 * Created by 的川 on 2018/5/10.
 */
@Component
public class App {

    private static String APPID = "wx9fabd35318ca5ed1";
    private static String SECRET = "77619f6371f6e773f76701ee60d63479";

    private static String TOKEN;


    public static String getAPPID() {
        return APPID;
    }


    public static String getSECRET() {
        return SECRET;
    }


    public static String getTOKEN() {
        return TOKEN;
    }


    @Scheduled(fixedDelay = 7100000)
    private void autoUpdateTOKEN() throws Exception{
        LocalTime time = LocalTime.now();
        System.out.println("自动更新token的时间:" + time);
        String urlParam = "https://api.weixin.qq.com/cgi-bin/token";
        Map<String, Object> params = new HashMap<>();
        params.put("appid", APPID);
        params.put("secret", SECRET);
        params.put("grant_type", "client_credential");
        String json = HttpRequestUtil.get(urlParam,params);
        System.out.println(JSONObject.toJSON(params).toString());
		System.out.println("json"+json);
        JSONObject ob = JSONObject.parseObject(json);
        System.err.println(ob.get("access_token"));
        App.TOKEN = (String) ob.get("access_token");
    }

}
