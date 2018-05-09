package cn.myzqu.vo;

import lombok.Data;

/**
 * 统一返回信息封装类
 * Created by 的川 on 2018/5/8.
 */
@Data
public class ResultVO<T> extends Result{

    /**
     * 具体内容
     */
    private T data;

}
