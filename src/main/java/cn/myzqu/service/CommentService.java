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

    /**
     * 根据用户id查询该用户所有的评论记录
     * @param userId
     * @return
     */
    List<Comment> findByUserId(String userId);

    /**
     * 根据id更新用户评论可见性
     * @param id
     * @return
     */
    Boolean updateById(String id);
}
