package cn.myzqu.enums;


/**
 * 题库类目级别
 * Created by 的川 on 2018/5/10.
 */

public enum CategoryLevelEnum {


    TOP(0,"顶级类目"),
    ;

    private Integer code;

    private String message;

    CategoryLevelEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
