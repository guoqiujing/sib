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
    LOGIN_NOT(1000,"请先登录"),
//    题库类

    BANK_CREATE_FAIL(2000,"创建题库失败"),
    BANK_UPDATE_FAIL(2001,"更新题库失败"),
    BANK_DELETE_FAIL(2002,"删除题库失败"),
    BANK_BUY_EXIST(2003,"该题库已购买"),
    BANK_BUY_FAIL(2004,"该题库购买失败"),
    BANK_IS_EXIST(2005,"该题库是自己的"),
    BANK_CHECK_FAIL(2006,"题库审核失败"),
    BANK_GREAT_FAIL(2007,"推荐题库修改失败"),

    BANK_NOT_EXIST(2100,"题库不存在"),

    BANKLIST_EMPTY(2200,"哎呀，暂时还没有题库哦"),

    BANK_TITLE_EXIST(2300,"题库名称已存在"),

    //题目类
    QUESTION_CREATE_FAIL(3000,"创建题目失败"),
    QUESTION_UPDATE_FAIL(3001,"更新题目失败"),
    QUESTION_DELETE_FAIL(3002,"删除题目失败"),
    QUESTION_SHARE_FAIL(3003,"题目分享失败"),
    QUESTION_CHECK_FAIL(3004,"题目审核失败"),

    QUESTION_NOT_EXIST(3100,"题目不存在"),
    QUESTION_IS_EXIST(3101,"题目已存在"),

    QUESTIONLIST_EMPTY(3200,"哎呀，暂时还没有题目哦"),

    //用户类
    USER_CREATE_FAIL(4000,"创建账号失败"),
    USER_UPDATE_FAIL(4002,"更新账号信息失败"),
    USER_DELETE_FAIL(4003,"删除账号失败"),
    PASSWORD_UPDATE_FAIL(4004,"更新密码失败"),
    USER_SIGN_FAIL(4005,"用户签到失败"),
    USER_SIGN_EXIST(4006,"用户已签到"),
    USER_SIGN_FULL(4007,"用户今日签到次数达到上限"),
    USER_SIGN_NOT_EXIST(4008,"用户未签到"),

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
    POINT_NOT_EXIST(8000,"积分记录不存在"),
    POINT_ADD_FAIL(8001,"批量增加用户积分失败"),
    POINT_USER_FALL(8002,"用户积分查询失败"),
    POINT_NOT_ENOUGHT(8003,"用户积分不够"),

    //题目星级类
    RATING_COMPLETION(9000,"你已经评价过该题的星级啦"),
    RATING_UNCOMPLETE(9001,"你还没评价这个题目的星级哦"),
    RATING_EMPTY(9002,"现在还没有星级评价记录"),

    //用户评论类
    COMMENT_EMPTY(10000,"该题目还没有评论哦"),
    COMMENT_FAIL(10100,"评论失败了呢，请稍后重试"),
    COMMENT_USER_EMPTY(10200,"你还有评论过题目哦"),
    COMMENT_UPDATE_FAIL(10300,"删除失败了呢，请稍后重试"),
    COMMENT_ALLEMPTY(10400,"暂时还没有用户评论呢"),

    //购买题库类
    BUY_BANK_EMPTY(11000,"查询不到购买记录"),

    //用户反馈类
    MESSAGE_FAIL(12000,"反馈失败了呢，请稍后重试"),
    MESSAGE_EMPTY(12100,"还没有用户反馈哦"),
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
