package cn.myzqu.dto;

import cn.myzqu.pojo.Message;
import lombok.Data;

/**
 * Created by xiraly on 2018/6/7.
 */
@Data
public class MessageDTO extends Message {
    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 题库标题
     */
    private String bankTitle;

    /**
     * 题目题干
     */
    private String question;
}
