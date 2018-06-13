package cn.myzqu.controller.admin;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.Message;
import cn.myzqu.service.MessageService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 反馈信息控制层
 * Created by xiraly on 2018/6/7.
 */
@RestController("AdminMessageController")
@RequestMapping("admin/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 根据题目id查询所有用户的评论记录
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/getList")
    public Result getMessageByUserId(@RequestParam(value="nickname",defaultValue = "") String nickname,
                                     @RequestParam(value="bankTitle",defaultValue = "") String bankTitle,
                                     @RequestParam(value="question",defaultValue = "") String question,
                                     @RequestParam(value="page",defaultValue = "1") Integer page,
                                     @RequestParam(value = "size",defaultValue = "10") Integer size){
        System.err.println(nickname);
        //调用messageService的findAllMessage方法查询出所有用户对该接收者的反馈记录
        PageDTO data = messageService.findAllMessage(nickname,bankTitle,question,page,size);
        //若没有就返回错误提示信息
        if(data==null)  return ResultVOUtil.error(ResultEnum.MESSAGE_EMPTY);
        //若有数据，则返回成功信息和数据
        return  ResultVOUtil.success(data.getRows(),data.getTotal());
    }
}
