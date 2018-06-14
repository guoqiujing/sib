package cn.myzqu.controller.user;

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
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 用户新增题目反馈记录
     * @param message  用户反馈记录对象
     * @return
     */
    @PostMapping("/addMessage")
    public Result addMessage(@Validated @RequestBody Message message){
        //调用messageService的addMessageRecord方法把数据插入数据库，成功则返回信息
        if(messageService.addMessageRecord(message)) {
            return ResultVOUtil.success();
        }
        //失败则返回异常
        return ResultVOUtil.error(ResultEnum.MESSAGE_FAIL);
    }

    /**
     * 根据题目id查询所有用户的评论记录
     * @param userId  用户id
     * @return
     */
    @GetMapping("/getMessage")
    public Result getMessageByUserId(@RequestParam String userId,
                                         @RequestParam(value="page",defaultValue = "1") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size){
        //调用messageService的findByUserId方法查询出所有用户对该接收者的反馈记录
        PageDTO data = messageService.findByUserId(userId,page,size);
        //若没有就返回错误提示信息
        if(data==null)  return ResultVOUtil.error(ResultEnum.MESSAGE_EMPTY);
        //若有数据，则返回成功信息和数据
        return  ResultVOUtil.success(data);
    }

    /**
     * 根据题目id查询所有用户的评论记录
     * @param userId  用户id
     * @return
     */
    @GetMapping("/list")
    public Result getListByUserId(@RequestParam String userId,
                                     @RequestParam(value="page",defaultValue = "1") Integer page,
                                     @RequestParam(value = "size",defaultValue = "10") Integer size){
        //调用messageService的findByUserId方法查询出所有用户对该接收者的反馈记录
        PageDTO data = messageService.findByUserId(userId,page,size);
        //若没有就返回错误提示信息
        if(data==null)  return ResultVOUtil.error(ResultEnum.MESSAGE_EMPTY);
        //若有数据，则返回成功信息和数据
        return  ResultVOUtil.success(data.getRows(),data.getTotal());
    }
}
