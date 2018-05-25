package cn.myzqu.enums;

/**
 * Created by 的川 on 2018/5/8.
 */
public enum ResultEnum {
    SUCCESS(0,"成功"),
    ERROR(-1,"哎呀，发生异常啦，请稍后重试！"),
    PARAMETER_ERROR(-2,"哎呀，请求参数错误啦"),
    SQL_ERROR(-3,"哎呀，操作数据异常啦"),
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
    QUESTION_IS_EXIST(3101,"题目已存在"),

    QUESTIONLIST_EMPTY(3200,"哎呀，暂时还没有题目哦"),

    //用户类
    USER_CREATE_FAIL(4000,"创建账号失败"),
    USER_UPDATE_FAIL(4002,"更新账号信息失败"),
    USER_DELETE_FAIL(4003,"删除账号失败"),
    PASSWORD_UPDATE_FAIL(4004,"更新密码失败"),

    USER_NAME_EXIST(4100,"用户名已存在，请换个试试"),
    PHONE_EXIST(4101,"该手机号码已经绑定其他账号"),
    EMAIL_EXITS(4102,"该邮箱已经绑定其他账号"),
    WXID_EXITS(4103,"该微信已经绑定其他账号"),

    USER_NOT_EXIST(4200,"用户不存在"),

    USERLIST_EMPTY(4300,"哎呀，暂时还没有用户哦"),

    PSSSWORD_ERROR(4400,"密码错误"),

    //题库类目类
    CATEGORY_CREATE_FAIL(5000,"创建题库类目失败"),
    CATEGORY_EXITS(5100,"题库类目已存在"),


    //答题类
    ANSWERSHEET_CREATE_FAIL(6000,"哎呀，提交答题记录失败啦"),
    ANSWERSHEETLIST_EMPTY(6100,"还没有答题记录哦"),

    //收藏类
    FAVORITE_EXIST(7000,"该题目已收藏"),
    FAVORITE_ERROR(7001,"收藏失败"),
    FAVORITE_CANCEL_ERROR(7002,"取消收藏失败"),
    FAVORITE_EMPTY(7003,"收藏记录为空"),

    //积分类
    POINT_SIGN_EXIST(8000,"用户已签到"),
    POINT_SIGN_ERROR(8001,"用户签到失败"),

    //题目星级类
    RATING_COMPLETION(9000,"你已经评价过该题的星级啦"),
    RATING_UNCOMPLETE(9001,"你还没评价这个题目的星级哦"),
    RATING_ENPTY(9002,"现在还没有星级评价记录"),
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
