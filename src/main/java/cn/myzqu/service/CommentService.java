package cn.myzqu.service;

import cn.myzqu.dto.CommentDTO;
import cn.myzqu.pojo.Comment;

import java.util.List;

/**
 * 用户评论服务接口
 * Created by xiraly on 2018/5/25.
 */
public interface CommentService {

    /**
     * 添加用户评论记录
     * @param record
     * @return
     */
    Boolean addCommentRecord(Comment record);

    /**
     * 根据题目id查询用户评论记录
     * @param questionId
     * @return
     */
    List<CommentDTO> findByQuestionId(String questionId);
}
