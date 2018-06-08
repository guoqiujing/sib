package cn.myzqu.controller.admin;

import cn.myzqu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户评论控制层
 * Created by xiraly on 2018/5/25.
 */
@RestController("AdminCommentController")
@RequestMapping("admin/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


}
