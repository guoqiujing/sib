package cn.myzqu.controller;

import cn.myzqu.dto.AnswerSheetDTO;
import cn.myzqu.dto.PageDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.AnswerSheet;
import cn.myzqu.service.AnswerSheetService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 答题控制处理器
 * Created by 的川 on 2018/5/10.
 */
@RestController
@RequestMapping("/answerSheet")
public class AnswerSheetController {

    @Autowired
    private AnswerSheetService answerSheetService;

    /**
     * 添加一条答题记录
     * @param answerSheet
     * @return
     */
    @PostMapping("/recode")
    public Result addAnswerSheet(@Validated AnswerSheet answerSheet){
        //调用answerSheetService，成功返回信息
        if(answerSheetService.add(answerSheet)) return ResultVOUtil.success();
        //失败返回
        return ResultVOUtil.error(ResultEnum.ANSWERSHEET_CREATE_FAIL);
    }

    /**
     * 获取单个用户的答题记录
     * @param userId 用户id
     * @return
     */
    @GetMapping("/list/{user_id}")
    public Result getUserAnswerSheet(@PathVariable("user_id") String userId){
        List<AnswerSheetDTO> data = answerSheetService.findByUserId(userId);
        if(data.size()>0) return ResultVOUtil.success(data);
        return ResultVOUtil.error(ResultEnum.ANSWERSHEETLIST_EMPTY);
    }

    /**
     * 获取单个用户的错题记录
     * @param userId 用户id
     * @return
     */
    @GetMapping("/list/{user_id}/fault")
    public Result getUserFaultAnswerSheet(@PathVariable("user_id") String userId){
        List<AnswerSheetDTO> data = answerSheetService.findFaultByUserId(userId);
        if(data.size()>0) return ResultVOUtil.success(data);
        return ResultVOUtil.error(ResultEnum.ANSWERSHEETLIST_EMPTY);
    }

    /**
     * 多条件分页查询
     * @param condition，说明 userId：用户id,answerIsTrue:答案是对还是错
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public Result getList(@RequestParam Map<String,Object> condition,
                          @RequestParam(value="page",defaultValue = "1") Integer page,
                          @RequestParam(value = "size",defaultValue = "10") Integer size){
        System.out.println(condition.get("userId"));
        PageDTO pageDTO = answerSheetService.findByCondition(condition,page,size);
        if (pageDTO!=null) return ResultVOUtil.success(pageDTO);
        return  ResultVOUtil.error(ResultEnum.ANSWERSHEETLIST_EMPTY);
    }

}
