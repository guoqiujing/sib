package cn.myzqu.controller;


import cn.myzqu.dto.UserDTO;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static cn.myzqu.enums.ResultEnum.LOGIN_FAIL;

/**
 * Created by 的川 on 2018/6/13.
 */
@RestController
@RequestMapping("session")
public class SessionController {

    @RequestMapping("/user")
    public Result getSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        if(userDTO!=null){
            System.out.println("当前请求用户："+userDTO);
            return ResultVOUtil.success(userDTO);
        }
        return ResultVOUtil.error(LOGIN_FAIL);

    }

}
