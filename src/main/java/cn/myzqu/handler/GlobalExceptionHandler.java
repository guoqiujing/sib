package cn.myzqu.handler;

import cn.myzqu.enums.ResultEnum;
import cn.myzqu.exception.CustomException;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import cn.myzqu.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
