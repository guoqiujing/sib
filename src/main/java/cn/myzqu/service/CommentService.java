package cn.myzqu.service;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.pojo.Comment;

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
    PageDTO findByQuestionId(String questionId, int pageNum, int pageSize);

    /**
     * 根据用户id查询该用户所有的评论记录
     * @param userId
     * @return
     */
    PageDTO findByUserId(String userId, int pageNum, int pageSize);

    /**
     * 根据id更新用户评论可见性
     * @param id
     * @return
     */
    Boolean updateById(String id);
}
