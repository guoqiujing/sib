package cn.myzqu.service.impl;

import cn.myzqu.dao.CommentMapper;
import cn.myzqu.dto.CommentDTO;
import cn.myzqu.pojo.Comment;
import cn.myzqu.service.CommentService;
import cn.myzqu.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户评论服务接口实现类
 * Created by xiraly on 2018/5/25.
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentMapper commentMapper;

    /**
     * 添加用户评论记录
     * @param record
     * @return
     */
    @Override
    public Boolean addCommentRecord(Comment record){
        //生成唯一id
        record.setId(KeyUtil.getUUID());
        record.setCreateTime(new Date());
        //调用CommentMapper的insert方法把用户评论记录插入到数据库
        if(commentMapper.insert(record)>0)
            //成功则返回true
            return true;
        else
            //失败则返回false
            return false;
    }

    /**
     * 根据题目id查询用户评论记录
     * @param questionId
     * @return
     */
    @Override
    public List<CommentDTO> findByQuestionId(String questionId){
        //调用commentMapper的selectByQuestionId方法查询出该题目所有的评论记录
        List<CommentDTO> list = commentMapper.selectByQuestionId(questionId);
        if(list.isEmpty())
            //没有就返回null
            return null;
        else
            //若有就返回数据
            return list;
    }

}
