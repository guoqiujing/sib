package cn.myzqu.enums;

/**
 * Created by 的川 on 2018/5/8.
 */
public enum ResultEnum {
    SUCCESS(0,"成功"),
    ERROR(-1,"哎呀，发生异常啦，请稍后重试！"),
    PARAMETER_ERROR(-2,"参数错误"),
//    登录
    LOGIN_FAIL(1000,"登录失败，登录信息不正确"),
//    题库类

    BANK_CREATE_FAIL(2000,"创建题库失败"),
    BANK_UPDATE_FAIL(2001,"更新题库失败"),
    BANK_DELETE_FAIL(2002,"删除题库失败"),

    BANK_NOT_EXIST(2100,"题库不存在"),

    BANKLIST_EMPTY(2200,"哎呀，暂时还没有题库哦"),

    BANK_TITLE_EXIST(2300,"题库名称已存在"),

    //题目类
    QUESTION_CREATE_FAIL(3000,"创建题目失败"),
    QUESTION_UPDATE_FAIL(3001,"更新题目失败"),
    QUESTION_DELETE_FAIL(3002,"删除题目失败"),

    QUESTION_NOT_EXIST(3100,"题目不存在"),

    QUESTIONLIST_EMPTY(3200,"哎呀，暂时还没有题目哦"),

    //用户类
    USER_CREATE_FAIL(4000,"创建账号失败"),
    USER_UPDATE_FAIL(4002,"更新账号信息失败"),
    USER_DELETE_FAIL(4003,"删除账号失败"),
    PASSWORD_UPDATE_FAIL(4004,"更新密码失败"),

    USER_ID_EXIST(4100,"用户名已存在，请换个试试"),
    PHONE_EXIST(4101,"该手机号码已经绑定其他账号"),
    EMAIL_EXITS(4102,"该邮箱已经绑定其他账号"),
    WXID_EXITS(4103,"该微信已经绑定其他账号"),

    USER_NOT_EXIST(4200,"用户不存在"),

    USERLIST_EMPTY(4300,"哎呀，暂时还没有用户哦"),

    PSSSWORD_ERROR(4400,"密码错误"),

    //题库类目类
    CATEGORY_CREATE_FAIL(5000,"创建题库类目失败"),
    CATEGORY_EXITS(5100,"题库类目已存在"),


    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
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
