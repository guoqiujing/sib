package cn.myzqu.controller.admin;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.service.CommentService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户评论控制层
 * Created by xiraly on 2018/5/25.
 */
@RestController("AdminCommentController")
@RequestMapping("admin/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 查找并分页显示所有用户评论记录
     * @param page  当前页数
     * @param size  当前页数的记录条数
     * @return
     */
    @GetMapping("/comment")
    public Result getAllRating(@RequestParam(value="nickname",defaultValue = "") String nickname,
                               @RequestParam(value="bankTitle",defaultValue = "") String bankTitle,
                               @RequestParam(value="question",defaultValue = "") String question,
                               @RequestParam(value="page",defaultValue = "1") Integer page,
                               @RequestParam(value = "size",defaultValue = "10") Integer size){
        System.err.println(bankTitle);
        Map<String,Object> map = new HashMap<>();
        map.put("nickname",nickname);
        map.put("bankTitle",bankTitle);
        map.put("question",question);
        PageDTO data = commentService.findAllComment(map,page,size);
        if(data==null) return ResultVOUtil.error(ResultEnum.COMMENT_ALLEMPTY);
        return ResultVOUtil.success(data.getRows(),data.getTotal());
    }

    /**
     * 根据id更新用户评论可见性(即---删除评论
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
