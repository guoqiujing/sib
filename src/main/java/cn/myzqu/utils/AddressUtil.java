package cn.myzqu.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取客户端地理位置
 * Created by 的川 on 2018/5/28.
 */
public class AddressUtil {

    private static  Logger logger = LoggerFactory.getLogger(AddressUtil.class);

    /**
     * 通过新浪接口获取地理位置
     * @param ip 客户端ip
     * @return
     * @throws IOException
     */
    public static String getAddressBySina (String ip) throws IOException {
        String urlParam = "https://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json";
        //封装请求参数
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ip", ip);
        String result = HttpRequestUtil.get(urlParam,params).trim();
        logger.info("Address:{}"+result);
        JSONObject object = JSONObject.parseObject(result);
        //获取省份
        String province = object.getString("province");
        //获取城市
        String city = object.getString("city");
        return province+city;
    }


}
