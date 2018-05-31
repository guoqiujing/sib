package cn.myzqu.controller;

import cn.myzqu.dto.CommentDTO;
import cn.myzqu.dto.PageDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.Comment;
import cn.myzqu.service.CommentService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户评论控制层
 * Created by xiraly on 2018/5/25.
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 添加用户评论记录
     * @param comment  用户评论记录对象
     * @return
     */
    @PostMapping("/addComment")
    public Result addComment(@Validated @RequestBody Comment comment){
        //调用commentService的addComment方法把数据插入数据库，成功则返回信息
        if(commentService.addCommentRecord(comment)) {
            return ResultVOUtil.success();
        }
        //失败则返回异常
        return ResultVOUtil.error(ResultEnum.COMMENT_FAIL);
    }

    /**
     * 根据题目id查询所有用户的评论记录
     * @param questionId  题目id
     * @return
     */
    @GetMapping("/getComment")
    public Result getCommentByQusetionId(@RequestParam String questionId,
                                         @RequestParam(value="page",defaultValue = "1") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size){
        //调用commentService的findByQuestionId方法查询出该题目的所有用户的评论记录
        PageDTO data = commentService.findByQuestionId(questionId,page,size);
        //若没有就返回错误提示信息
        if(data==null)  return ResultVOUtil.error(ResultEnum.COMMENT_EMPTY);
        //若有数据，则返回成功信息和数据
        return  ResultVOUtil.success(data);
    }

    /**
     * 根据用户id查询该用户的评论记录
     * @param userId  用户id
     * @return
     */
    @GetMapping("/getUserComment")
    public Result getCommentByUserId(@RequestParam String userId,
                                     @RequestParam(value="page",defaultValue = "1") Integer page,
                                     @RequestParam(value = "size",defaultValue = "10") Integer size){
        //调用commentService的findByUserId方法查询出该用户的所有评论记录
        PageDTO data = commentService.findByUserId(userId,page,size);
        //若没有就返回错误提示信息
        if(data==null)  ResultVOUtil.error(ResultEnum.COMMENT_USER_EMPTY);
        //若有数据，则返回成功信息和数据
        return ResultVOUtil.success(data);
    }

    /**
     * 根据id更新用户评论可见性(即删除
     * @param id  用户评论记录id（不是用户id
     * @return
     */
     @PutMapping("/updateComment")
    public Result updateComment(@RequestParam String id){
         //调用commentService的updateById方法更新数据库，成功则返回成功信息
         if(commentService.updateById(id)) {
             return ResultVOUtil.success();
         }
         //失败则返回异常
         return ResultVOUtil.error(ResultEnum.COMMENT_UPDATE_FAIL);
     }
}
