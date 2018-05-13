package cn.myzqu.handler;

import cn.myzqu.enums.ResultEnum;
import cn.myzqu.exception.CustomException;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 统一异常处理器
 * Created by 的川 on 2018/5/9.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public Result customExceptionHandler(CustomException e){
        logger.error(e.getMessage(),e);
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

    /**
     * 处理表单验证错误
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public Result bindExceptionHandler(BindException e){
        logger.error(e.getMessage(),e);
        List<ObjectError> errors = e.getAllErrors();
        Map<String,Object> data = new HashMap<>();
       // List<Object> data = new ArrayList();
        for(ObjectError error:errors){
            System.out.println(error.getCodes().toString());
            data.put(error.getDefaultMessage(),error.getDefaultMessage());
           // data.add(error.getDefaultMessage());
        }
        return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR,data);
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    public Result sqlExceptionHandler(Exception e){
        logger.error(e.getMessage(),e);
        return ResultVOUtil.error(ResultEnum.SQL_ERROR);
    }

    /**
     * 处理系统异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result ExceptionHandler(Exception e){
        logger.error(e.getMessage(),e);
        return ResultVOUtil.error(ResultEnum.ERROR);
    }

}
