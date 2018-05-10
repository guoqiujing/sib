package cn.myzqu.pojo.wechat;

import lombok.Data;

/**
 * 微信小程序敏感信息类
 * Created by 的川 on 2018/5/10.
 */
@Data
public class App {

    private static String APPID = "wx9fabd35318ca5ed1";
    private static String SECRET = "77619f6371f6e773f76701ee60d63479";

    public static String getAPPID() {
        return APPID;
    }

    public static String getSECRET() {
        return SECRET;
    }
}
