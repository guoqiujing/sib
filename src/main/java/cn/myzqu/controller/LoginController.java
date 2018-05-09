package cn.myzqu.controller;

import cn.myzqu.enums.ResultEnum;
import cn.myzqu.service.UserService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import cn.myzqu.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 * Created by 的川 on 2018/5/9.
 */
@RestController
public class LoginController {


    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param code
     * @param password
     * @return
     */
    @GetMapping("/login")
    public Result login(String code, String password){
        if(userService.login(code,password)){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
    }
}
