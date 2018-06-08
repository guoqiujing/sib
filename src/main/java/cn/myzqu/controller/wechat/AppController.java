package cn.myzqu.controller.wechat;

import cn.myzqu.pojo.wechat.App;
import cn.myzqu.utils.HttpRequestUtil;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 的川 on 2018/5/10.
 */
@RestController
@RequestMapping("/wechat")
public class AppController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/openid")
    public Result getOpenId(String code) {
        //向腾讯服务器请求获取用户openid
        //请求地址
        String urlParam = "https://api.weixin.qq.com/sns/jscode2session";
        //封装请求参数
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("appid", App.getAPPID());
        params.put("secret", App.getSECRET());
        params.put("js_code", code);
        params.put("grant_type", "authorization_code");
        //发送请求
        String result = HttpRequestUtil.get(urlParam,params);
        logger.info("result:{}"+result);
        JSONObject object = JSONObject.parseObject(result);
        //获取openid
        String openid = object.getString("openid");
        if(!StringUtils.isEmpty(openid)){
            Map<String,Object> data = new HashMap<>();
            data.put("openid",openid);
            return ResultVOUtil.success(data);
        }
        return ResultVOUtil.error(9000,"获取用户openid错误");
    }

    /**
     * 获取小程序的token
     * @return
     */
    @GetMapping("/token")
    public Result getToken() {
        Map<String,Object> data = new HashMap<>();
        data.put("token",App.getTOKEN());
        return ResultVOUtil.success(data);
    }
}
