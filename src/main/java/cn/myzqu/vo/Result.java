package cn.myzqu.vo;

import lombok.Data;

/**
 * 统一返回信息封装类
 * Created by 的川 on 2018/5/9.
 */
@Data
public class Result {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;
}
