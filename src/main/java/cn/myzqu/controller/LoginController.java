package cn.myzqu.controller;

import cn.myzqu.dto.UserDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.User;
import cn.myzqu.pojo.UserRole;
import cn.myzqu.service.UserRoleService;
import cn.myzqu.service.UserService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录控制器
 * Created by 的川 on 2018/5/9.
 */
@RestController
public class LoginController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 登录
     * @param code
     * @param password
     * @return
     */
    @GetMapping("api/login")
    public Result login(String code, String password,HttpServletRequest request){
        HttpSession session = request.getSession(true);
        User user = userService.login(code,password);
        if(user!=null){
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user,userDTO);
            //生成session
            session.setAttribute("user",userDTO);
            //判断用户身份
            UserRole userRole = userRoleService.findByUserId(userDTO.getId());
            if(userRole.getRoleName().equals("user"))
                return ResultVOUtil.success("user/index");
            else if(userRole.getRoleName().equals("admin"))
                return ResultVOUtil.success("admin/index");
        }
        return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
    }
    @GetMapping("api/logout")
    public Result logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return ResultVOUtil.success();
    }
}
