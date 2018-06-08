package cn.myzqu.utils;

import cn.myzqu.enums.ResultEnum;
import cn.myzqu.vo.ListResultVO;
import cn.myzqu.vo.Result;
import cn.myzqu.vo.ResultVO;

/**
 * 生成返回信息工具类
 * Created by 的川 on 2018/5/8.
 */
public class ResultVOUtil {
    /**
     * 返回成功信息，带具体内容DATA
     * @param object
     * @return
     */
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(ResultEnum.SUCCESS.getMessage());
        resultVO.setData(object);
        return resultVO;
    }

    /**
     * 返回成功信息，专门为列表
     * @param object
     * @param total
     * @return
     */
    public static ListResultVO success(Object object,int total){
        ListResultVO listResultVO = new ListResultVO();
        listResultVO.setCode(ResultEnum.SUCCESS.getCode());
        listResultVO.setMsg(ResultEnum.SUCCESS.getMessage());
        listResultVO.setData(object);
        listResultVO.setTotal(total);
        return listResultVO;
    }



    /**
     * 返回成功信息
     * @return
     */
    public static Result success(String msg){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(msg);
        return result;
    }

    /**
     * 返回成功信息
     * @return
     */
    public static Result success(){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMessage());
        return result;
    }

    /**
     * 返回失败信息
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 返回失败信息
     * @param resultEnum
     * @return
     */
    public static Result error(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMessage());
        return result;
    }

    /**
     * 返回错误信息
     * @param resultEnum
     * @param object
     * @return
     */
    public static ResultVO error(ResultEnum resultEnum,Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());
        resultVO.setData(object);
        return resultVO;
    }


}
