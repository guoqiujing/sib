package cn.myzqu.dto;

import cn.myzqu.pojo.Comment;
import lombok.Data;

/**
 * 评论扩展类
 * Created by xiraly on 2018/5/25.
 */
@Data
public class CommentDTO extends Comment{
    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String icon;

}
