package cn.myzqu.dao;

import cn.myzqu.dto.CommentDTO;
import cn.myzqu.pojo.Comment;

import java.util.List;

public interface CommentMapper {

    /**
     * 添加用户评论
     * @param record 用户评论记录
     * @return
     */
    int insert(Comment record);

    /**
     * 根据题目id查询所有用户评论
     * @param questionId 题目id
     * @return
     */
    List<CommentDTO> selectByQuestionId(String questionId);

    /**
     * 修改用户评论可见性
     * @param record
     * @return
     */
    int updateById(Comment record);

    /**
     * 根据用户id查询用户评论
     * @param userId
     * @return
     */
    List<CommentDTO> selectByUserId(String userId);

    /**
     * 查询所有用户评论记录
     */
    List<Comment> selectAllComment();
}