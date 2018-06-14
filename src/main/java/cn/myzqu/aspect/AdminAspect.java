package cn.myzqu.aspect;

import cn.myzqu.dto.UserDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.exception.CustomException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 的川 on 2018/6/14.
 */
@Aspect
@Component
public class AdminAspect {

    @Pointcut("execution(public * cn.myzqu.controller.NavController.admin(..))")
    public void verify(){

    }

    @Before("execution(public * cn.myzqu.controller.NavController.admin(..))")
    public void doVerify(JoinPoint jp) throws CustomException {
        System.out.println("开始执行验证admin身份:"+jp.getSignature().getName());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
        System.out.println(userDTO);
        if(StringUtils.isEmpty(userDTO)){
            throw new CustomException(ResultEnum.LOGIN_NOT);
        }
    }
}
